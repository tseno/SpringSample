package com.example.springsample.login.domain.repository.mybatis;

import com.example.springsample.login.domain.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper2 {

    public boolean insert(User user);

    public User selectOne(String userId);

    public List<User> selectMany();

    public boolean updateOne(User user);

    public boolean deleteOne(String userId);
}
