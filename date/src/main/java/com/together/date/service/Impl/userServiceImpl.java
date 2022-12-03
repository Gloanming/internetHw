package com.together.date.service.Impl;

import com.together.date.Dao.userDao;
import com.together.date.Vo.loginVo;
import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;
import com.together.date.service.userService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Service

@Slf4j
public class userServiceImpl implements userService {
    @Autowired
    userDao UserDao;

    user User;
    @Override
    public result add(user person) {
        return null;
    }
    @Override
    public result login(loginVo LoginVo){
        User = UserDao.selectUserById(LoginVo.getIdentity());
        if (User == null){
            //新用户
            return result.fail("您是新用户,请先注册后登录", null);
        }else{
            if (Objects.equals(User.getUserPwd(), LoginVo.pwd))
                return result.success("用户:"+ User.getUserId()+"登录", User);
            else {
                return result.fail("密码错误，请重新输入", User);
            }
        }
    }

    @Override
    public result register(registerVo RegisterVo){
        try{
            UserDao.addUser(RegisterVo);
            return result.success("注册成功", UserDao.selectUserById(RegisterVo.getIdentity()));
        } catch (DuplicateKeyException e) {
            return result.fail("用户openid已经存在", UserDao.selectUserById(RegisterVo.getIdentity()));
        }
    }



}
