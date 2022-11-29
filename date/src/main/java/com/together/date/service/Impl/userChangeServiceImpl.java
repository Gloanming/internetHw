package com.together.date.service.Impl;

import com.together.date.Dao.userDao;
import com.together.date.Vo.loginVo;
import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;
import com.together.date.service.userChangeService;
import com.together.date.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service

@Slf4j
public class userChangeServiceImpl implements userChangeService {
    @Autowired
    userDao UserDao;

    @Override
    public result changeUserName(String newName, String userId) {
        UserDao.changeUserNameById(newName, userId);
        return result.success("更改成功");
    }
    @Override
    public result changeUserSex(String sex, String userId) {
        UserDao.changeUserSexById(sex, userId);
        return result.success("更改成功");
    }
    @Override
    public result changeUserPwd(String pwd, String userId){
        UserDao.changeUserPwdById(pwd, userId);
        return result.success("更改成功,请记住您的新密码");
    }
    @Override
    public result changeUserAvatarUrl(String avatarUrl, String Id) {
        UserDao.changeUserAvatarUrlById(avatarUrl, Id);
        return result.success("更换成功");
    }
}
