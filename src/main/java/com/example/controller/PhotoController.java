package com.example.controller;

import com.example.model.Comment;
import com.example.repository.PhotoRepository;
import com.mongodb.gridfs.GridFSDBFile;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by benny on 23.11.15.
 */
@Controller

public class PhotoController {

    @Autowired
    GridFsTemplate gridFsTemplate;

     PhotoRepository photoRepository;
    @Autowired
    MongoRepository mongoRepository;

    @Autowired
    private MongoTemplate mongo;



    @RequestMapping(value="{fileName}")
    public @ResponseBody
    ResponseEntity<InputStreamResource> getFile(@PathVariable String fileName){
        GridFSDBFile file = gridFsTemplate.findOne(new Query(Criteria.where("filename").is(fileName)));
        System.out.println(file);
        return ResponseEntity.ok()
                .contentLength(file.getLength())
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(new InputStreamResource(file.getInputStream()));
    }


    //Viser bildene på nettsiden
    @RequestMapping(value="/photo/{iD}")
    public @ResponseBody
    ResponseEntity<InputStreamResource> getFiles(@PathVariable String iD){
        GridFSDBFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(iD)));
        System.out.println(file);
        return ResponseEntity.ok()
                .contentLength(file.getLength())
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .body(new InputStreamResource(file.getInputStream()));
    }





    @RequestMapping(value = "/photo/page/{iD}", method = RequestMethod.GET)
    public String fotoId(@PathVariable String iD, ModelMap model){

        List<GridFSDBFile> fotoList =
                gridFsTemplate.find(new Query(Criteria.where("_id").is(iD)));
        List comments = mongo.findAll(Comment.class);


        model.put("comments",comments);
        model.addAttribute("fotoList", fotoList);



        return "photo";
    }







    @RequestMapping(value = "/photo/delete/{iD}", method = RequestMethod.GET)
     String deleteImage(@PathVariable String iD, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        gridFsTemplate.delete(new Query(Criteria.where("_id").is(iD).and("metadata.username").is(userName)));
        return "profile";
    }




}
