package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by benny on 23.11.15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public UserRepository getRepository() {
        return repository;
    }

    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    public User findByUsername(String username){
        return repository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
