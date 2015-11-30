package com.example.service;

import com.example.model.User;

/**
 * Created by benny on 23.11.15.
 */
public interface UserService {

        public User findByUsername(String username);
        public void save(User user);
        public void deleteAll();


    }
