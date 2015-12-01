package com.example.controller;

import com.example.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.Principal;

/**
 * Created by benny on 24.11.15.
 */
@Controller
public class UploadController {

    @Autowired
    GridFsTemplate gridFsTemplate;




    @RequestMapping(value="/upload", method= RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file, @RequestParam("tags") String tags){

        if (!file.isEmpty()) {
            try {

                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                String userName = auth.getName();

                DBObject metaData = new BasicDBObject();
                metaData.put("username", userName);




                byte[] bytes = file.getBytes();
                InputStream inputStream = new ByteArrayInputStream(bytes);
                gridFsTemplate.store(inputStream, name ,file.getContentType(),metaData);

                return userName + " successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }

    @RequestMapping("/upload")
    public ModelAndView indexPage(){
        ModelAndView view = new ModelAndView();
        view.setViewName("upload");
        return view;
    }

}
