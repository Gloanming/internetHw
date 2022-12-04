package com.together.date.service.Impl;

import com.together.date.Dao.userDao;
import com.together.date.Vo.loginVo;
import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;
import com.together.date.service.userChangeService;
import com.together.date.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class userChangeServiceImpl implements userChangeService {
    @Autowired
    userDao UserDao;

    @Override
    public result changeUserName(String newName, String userId) {
        if (UserDao.selectUserById(userId) == null) {
            System.out.println("缺少信息");
            return result.fail("缺少用户信息",null);
        }
        if (!Objects.equals(newName, UserDao.selectUserById(userId).getUserName())) {
            UserDao.changeUserNameById(newName, userId);
            System.out.println("更改name成功");
            return result.success("更改成功", UserDao.selectUserById(userId));
        } else {
            System.out.println("please different name");
            return result.fail("请输入与之前不同的名字",UserDao.selectUserById(userId));
        }

    }
    @Override
    public result changeUserSex(String sex, String userId) {
        UserDao.changeUserSexById(sex, userId);
        System.out.println("change sex");
        return result.success("更改成功", UserDao.selectUserById(userId));
    }
    @Override
    public result changeUserPwd(String pwd, String userId){
        if (UserDao.selectUserById(userId) == null) {
            System.out.println("缺少用户信息");
            return result.fail("缺少用户信息",null);
        }
        if (!Objects.equals(pwd, UserDao.selectUserById(userId).getUserPwd())) {
            UserDao.changeUserPwdById(pwd, userId);
            System.out.println("更改pwd成功");
            return result.success("更改成功,请记住您的新密码", UserDao.selectUserById(userId));
        } else {
            System.out.println("请输入不同的密码");
            return result.fail("请输入不同的密码",UserDao.selectUserById(userId));
        }
    }
    @Override
    public result changeUserAvatarUrl(String avatarUrl, String Id) {
        UserDao.changeUserAvatarUrlById(avatarUrl, Id);
        System.out.println("change avatarUrl");
        return result.success("更换成功", UserDao.selectUserById(Id));
    }
}
