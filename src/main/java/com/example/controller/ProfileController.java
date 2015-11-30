package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by benny on 25.11.15.
 */
@Controller
public class ProfileController {


    @Autowired
    UserRepository userRepository;

    @Autowired
    GridFsTemplate gridFsTemplate;





    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String fotoId(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        List<GridFSDBFile> fotoList =
                gridFsTemplate.find(new Query(Criteria.where("metadata.username").is(userName)));
        model.addAttribute("fotoList", fotoList);
        return "profile";
    }





}