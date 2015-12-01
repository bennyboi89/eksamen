package com.example.controller;

import com.example.model.Comment;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by benny on 30.11.15.
 */
@Controller
public class CommentController {

    @Autowired
    private MongoTemplate mongo;


    @RequestMapping(value="/photo/lol", method = RequestMethod.GET)
    public String goHome(ModelMap model) {
        //retrieves all the comments stored in the database
        List comments = mongo.findAll(Comment.class);

        model.put("comments",comments);

        return "photo";
    }


    @RequestMapping(value="photo/page/comment/add", method = RequestMethod.POST)
    public @ResponseBody
    String getComments(@RequestBody final String json){

        boolean error = false;
        Comment comment = new Gson().fromJson(json, Comment.class);
        comment.setCurrentDate();

        try{

            mongo.save(comment);
        }catch(Exception ex){
            error = true;
            ex.printStackTrace();
        }

        if(error)
            return "error";
        else{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(comment);
        }
    }

}
