package com.example.repository;

import com.example.model.Thumbnail;

import java.util.List;

/**
 * Created by benny on 23.11.15.
 */
public interface ThumbnailRepository {

    public List<Thumbnail> getThumbnailsByIds(List<Integer> listOfThumbnails);

    byte[] findByThumbnailId(int imageId);

    public void insert(Thumbnail thumbnail);

    public boolean deleteByThumbnailId(int thumbnailId);
}
