package com.together.date.service.Impl;

import com.together.date.Dao.userDao;
import com.together.date.result.result;
import com.together.date.service.userChangeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

@Slf4j
public class userChangeServiceImpl implements userChangeService {
    @Autowired
    userDao UserDao;

    @Override
    public result changeUserName(String newName, String userId) {
        if (!Objects.equals(newName, UserDao.selectUserById(userId).getUserName())) {
            UserDao.changeUserNameById(newName, userId);
            return result.success("更改成功", UserDao.selectUserById(userId));
        } else {
            return result.fail("请输入与之前不同的名字",UserDao.selectUserById(userId));
        }

    }
    @Override
    public result changeUserSex(String sex, String userId) {
        UserDao.changeUserSexById(sex, userId);
        return result.success("更改成功", UserDao.selectUserById(userId));
    }
    @Override
    public result changeUserPwd(String pwd, String userId){
        if (!Objects.equals(pwd, UserDao.selectUserById(userId).getUserPwd())) {
            UserDao.changeUserPwdById(pwd, userId);
            return result.success("更改成功,请记住您的新密码", UserDao.selectUserById(userId));
        } else {
            return result.fail("请输入不同的密码",UserDao.selectUserById(userId));
        }
    }
    @Override
    public result changeUserAvatarUrl(String avatarUrl, String Id) {
        UserDao.changeUserAvatarUrlById(avatarUrl, Id);
        return result.success("更换成功", UserDao.selectUserById(Id));
    }
}
