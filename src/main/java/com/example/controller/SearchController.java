package com.example.controller;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by benny on 26.11.15.
 */
@Controller
public class SearchController {


    @Autowired
    GridFsTemplate gridFsTemplate;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String fotoId(Model model){
        List<GridFSDBFile> fotoList = gridFsTemplate.find(new Query());
        model.addAttribute("fotoList", fotoList);
        return "index";
    }
}
