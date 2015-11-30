package com.example.repository;

import com.example.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by benny on 21.10.15.
 */
public interface UserRepository extends MongoRepository<User, String> {
    public User findByUsernameAndPassword(String username, String password);
    public User findByUsername(String username);



}
