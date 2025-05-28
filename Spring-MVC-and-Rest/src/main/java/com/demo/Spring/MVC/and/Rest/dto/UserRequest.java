package com.demo.Spring.MVC.and.Rest.dto;

import com.demo.Spring.MVC.and.Rest.model.User;

public class UserRequest {
    private String name;
    private  String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static UserRequest fromUser(User user) {
        UserRequest request = new UserRequest();
        request.setName(user.getName());
        request.setEmail(user.getEmail());

        return request;
    }
}
