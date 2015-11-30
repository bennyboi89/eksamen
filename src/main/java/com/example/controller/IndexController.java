package com.example.controller;

import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by benny on 02.11.15.
 */

@Controller
public class IndexController {

    @Autowired
    GridFsTemplate gridFsTemplate;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String fotoId(Model model){
        List<GridFSDBFile> fotoList = gridFsTemplate.find(new Query());
        model.addAttribute("fotoList", fotoList);
        return "index";
    }

}
