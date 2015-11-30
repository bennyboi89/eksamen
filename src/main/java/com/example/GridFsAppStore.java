package com.example;

import com.example.config.SpringMongoConfig;
import com.example.repository.PhotoRepository;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.gridfs.GridFsOperations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by benny on 23.11.15.
 */
public class GridFsAppStore {

    public static void main(String[] args) {

        ApplicationContext ctx =
                new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        GridFsOperations gridOperations =
                (GridFsOperations) ctx.getBean("gridFsTemplate");


        PhotoRepository photoRepository = (PhotoRepository) ctx.getBean("photorepository");



/*
        DBObject metaData = new BasicDBObject();
        metaData.put("extra1", "anything 1");
        metaData.put("extra2", "anything 2");

        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("/home/benny/Downloads/Mario.png");
            gridOperations.store(inputStream, "testing.png", "image/png", metaData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
*/
        System.out.println("Done");
    }
}
