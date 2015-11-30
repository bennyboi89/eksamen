package com.example.model;

import org.springframework.security.core.authority.AuthorityUtils;

/**
 * Created by benny on 21.10.15.
 */
public class UserSecurity extends
        org.springframework.security.core.userdetails.User {
    private User user;

    public UserSecurity(User user) {
        super(user.getUsername(), user.getPassword(), AuthorityUtils
                .createAuthorityList(user.getRole().toString()));
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public String getId() {
        return user.getId();
    }

    public String getRole() {
        return user.getRole();
    }
}