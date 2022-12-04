package com.together.date.ControllerTest.mapper;

import com.together.date.Dao.userDao;
import com.together.date.DateApplication;
import com.together.date.Vo.registerVo;
import com.together.date.service.entity.user;
import org.junit.jupiter.api.Assertions;
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
public class UserDaoTest {
    @Autowired
    userDao UserDao;

    @Test
    public void addUserTest() {
        registerVo RegisterVo = new registerVo("211250","ycc","mjl","man",100,"yccnb");
        UserDao.addUser(RegisterVo);
    }
    @Test
    public void SelectTest() {
        user User = new user();
        User.setUserId("ycc");
        User.setUserPwd("123");
        User.setUserName("dashuaibi");
        User.setAvatarUrl("mjl");
        User.setUserCreditIndex(100);
        Assertions.assertEquals(User, UserDao.selectUserById("ycc"));
    }

    @Test
    public void changeTest() {
        user User = new user();
        User.setUserId("211250");
        User.setUserPwd("yccnbm");
        User.setAvatarUrl("mjl");
        User.setUserCreditIndex(100);

        User.setUserSex("man");
        User.setUserName("ycc");
        UserDao.changeUserPwdById("yccnbm", "211250");
        user Us = UserDao.selectUserById("211250");
        Assertions.assertEquals(User.getUserPwd(),UserDao.selectUserById("211250").getUserPwd());
    }

}
