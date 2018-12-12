package com.example.springsample.login.domain.repository.jdbc;

import com.example.springsample.login.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDaoJdbcImpl4")
public class UserDaoJdbcImpl4 extends UserDaoJdbcImpl {

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public List<User> selectMany() {
        String sql = "SELECT * FROM m_user";

        UserResultSetExtractor extractor = new UserResultSetExtractor();

        return jdbc.query(sql, extractor);
    }

}
