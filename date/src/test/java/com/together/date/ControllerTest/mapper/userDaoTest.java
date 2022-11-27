package com.together.date.ControllerTest.mapper;

import com.together.date.Dao.userDao;
import com.together.date.DateApplication;
import com.together.date.Vo.registerVo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes = DateApplication.class)
@ExtendWith(SpringExtension.class)
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class userDaoTest {
    @Autowired
    userDao UserDao;
    @Test
    public void addUserTest() {
        registerVo RegisterVo = new registerVo("32424243","yccdashuaibi","mjl","man",100,"123");
        UserDao.addUser(RegisterVo);
    }

}
