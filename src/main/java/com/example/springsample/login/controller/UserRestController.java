package com.example.springsample.login.controller;

import com.example.springsample.login.domain.model.User;
import com.example.springsample.login.domain.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    @Qualifier("RestServiceMybatisImpl")
    RestService service;

    @GetMapping("/rest/get")
    public List<User> getUserMany() {
        return service.selectMany();
    }

    @GetMapping("/rest/get/{id:.+}")
    public User getUserOne(@PathVariable("id") String userId) {
        return service.selectOne(userId);
    }

    @PostMapping("/rest/insert")
    public String postUserOne(@RequestBody User user) {
        boolean result = service.insert(user);
        String str = "";
        if (result) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }

    @PutMapping("/rest/update")
    public String putUserOne(@RequestBody User user) {
        boolean result = service.update(user);
        String str = "";
        if (result) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }

    @DeleteMapping("/rest/delete//{id:.+}")
    public String deleteUserOne(@PathVariable("id") String userId) {
        boolean result = service.delete(userId);
        String str = "";
        if (result) {
            str = "{\"result\":\"ok\"}";
        } else {
            str = "{\"result\":\"error\"}";
        }
        return str;
    }
}
