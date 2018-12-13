package com.example.springsample;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringSampleApplicationTests {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    public void contextLoads() {
    }

    @Ignore
    @Test
    public void passwordEncoder() {

        System.out.println(passwordEncoder.encode("password"));
    }

}
