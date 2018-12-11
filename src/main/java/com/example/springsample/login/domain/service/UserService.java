package com.example.springsample.login.domain.service;

import com.example.springsample.login.domain.model.User;
import com.example.springsample.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class UserService {

    private final UserDao dao;

    @Autowired
    public UserService(@Qualifier("UserDaoJdbcImpl4") UserDao dao) {
        this.dao = dao;
    }

    public int count() {
        return dao.count();
    }

    public List<User> selectMany() {
        return dao.selectMany();
    }

    public User selectOne(String userId) {
        return dao.selectOne(userId);
    }

    public boolean insert(User user) {
        int rowNumber = dao.insertOne(user);

        boolean result = false;
        if (rowNumber > 0) {
            result = true;
        }
        return result;
    }

    public boolean updateOne(User user) {
        int rowNumber = dao.updateOne(user);

        boolean result = false;
        if (rowNumber > 0) {
            result = true;
        }
        return result;
    }

    public boolean deleteOne(String userId) {
        int rowNumber = dao.deleteOne(userId);

        boolean result = false;
        if (rowNumber > 0) {
            result = true;
        }
        return result;
    }

    public void userCsvOut() throws DataAccessException {
        dao.userCsvOut();
    }

    public byte[] getFile(String fileName) throws IOException {

        FileSystem fs = FileSystems.getDefault();
        Path p = fs.getPath(fileName);
        byte[] bytes = Files.readAllBytes(p);

        return bytes;
    }

}
