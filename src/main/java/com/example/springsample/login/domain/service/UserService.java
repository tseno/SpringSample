package com.example.springsample.login.domain.service;

import com.example.springsample.login.domain.model.User;
import com.example.springsample.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    final
    UserDao dao;

    @Autowired
    public UserService(@Qualifier("userDaoJdbcImpl") UserDao dao) {
        this.dao = dao;
    }

    public boolean insert(User user) {
        int rowNumber = dao.insertOne(user);

        boolean result = false;
        if (rowNumber > 0) {
            result = true;
        }
        return result;
    }

    public int count() {
        return dao.count();
    }

    public List<User> selectMany() {
        return dao.selectMany();
    }
}
