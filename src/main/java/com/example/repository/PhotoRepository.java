package com.example.repository;

import com.example.model.Photo;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import java.io.InputStream;
import java.util.List;

/**
 * Created by benny on 23.11.15.
 */
public interface PhotoRepository {

    public String store(InputStream inputStream, String fileName, String contentType, DBObject metaData);

    public GridFSDBFile retrieve(String fileName);

    public GridFSDBFile getById(String id);

    public GridFSDBFile getByFilename(String filename);

    public List findAll();



}
