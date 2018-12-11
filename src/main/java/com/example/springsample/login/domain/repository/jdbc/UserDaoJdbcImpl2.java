package com.example.springsample.login.domain.repository.jdbc;

import com.example.springsample.login.domain.model.User;
import com.example.springsample.login.domain.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository("UserDaoJdbcImpl2")
public class UserDaoJdbcImpl2 extends UserDaoJdbcImpl {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User selectOne(String userId) {
        String sql = "SELECT * FROM m_user WHERE user_id = ?";

        UserRowMapper rowMapper = new UserRowMapper();

        return jdbc.queryForObject(sql, rowMapper, userId);
    }

    @Override
    public List<User> selectMany()  {
        String sql = "SELECT * FROM m_user";

        RowMapper<User> rowMapper = new UserRowMapper();

        return jdbc.query(sql, rowMapper);
    }

}
