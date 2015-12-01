package com.example.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by benny on 26.11.15.
 */
//Indicates this class is a candidate for mapping to the database
@Document(collection = "comments")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    //Applied at the field level to mark the field used for identity purpose
    @Id
    private String id;


    String text;
    String nick;
    String date;

    public Comment(String text, String nick) {
        this.text = text;
        this.nick = nick;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");
        this.date = sdf.format(new Date());
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

    public void setCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy hh:mm");
        this.date = sdf.format(new Date());
    }
    //Getters Setters


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
