package com.example;

import com.example.model.User;
import com.example.service.UserService;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import org.jongo.Jongo;
import org.jongo.MongoCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages =  {"com.example.repository"})
@SpringBootApplication
@RestController
public class EksamenApplication implements CommandLineRunner {

    @Autowired
    UserService service;


    public static void main(String[] args) {
        SpringApplication.run(EksamenApplication.class, args);
    }



    @Override
    public void run(String... arg0) throws Exception {
        service.deleteAll();
        User user = new User("demo", "demo", "ADMIN");
        service.save(user);




    }

/*
    @Bean
    public Jongo jongo() {
        DB db;
        try {
            db = new MongoClient("127.0.0.1", 27017).getDB("test");
        } catch (UnknownHostException e) {
            throw new MongoException("Connection error : ", e);
        }
        return new Jongo(db);
    }

    @Bean
    public MongoCollection users() {
        return jongo().getCollection("users");
    }
    */



}
