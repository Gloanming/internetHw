package com.together.date.service.Impl;

import com.together.date.Dao.userDao;
import com.together.date.Vo.creditVo;
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
            System.out.println("新用户请先注册后登录");
            return result.fail("您是新用户,请先注册后登录", null);

        }else{
            if (Objects.equals(User.getUserPwd(), LoginVo.pwd)) {
                System.out.println("用户"+ User.getUserId() + "登录");
                return result.success("用户:"+ User.getUserId()+"登录", User);
            }
            else {
                System.out.println("密码错误");
                return result.fail("密码错误，请重新输入", User);
            }
        }
    }

    @Override
    public result register(registerVo RegisterVo){
        try{
            UserDao.addUser(RegisterVo);
            System.out.println("注册成功");
            return result.success("注册成功", UserDao.selectUserById(RegisterVo.getIdentity()));
        } catch (DuplicateKeyException e) {
            System.out.println("已存在用户");
            return result.fail("用户openid已经存在", UserDao.selectUserById(RegisterVo.getIdentity()));
        }
    }

    @Override
    public result breakRule(creditVo CreditVo) {
        User = UserDao.selectUserById(CreditVo.getUserId());
        if (User == null) {
            return result.fail("找不到用户", null);
        }
        UserDao.changeUserCredit(User.getUserId(), CreditVo.getCommand());
        System.out.println(CreditVo.getUserId() + ": -1 分");
        return result.success("扣分成功", UserDao.selectUserById(CreditVo.getUserId()));
    }
    @Override
    public result getInformation(user User) {
        if(User == null) {
            System.out.println("不存在用户");
            return result.fail("不存在用户",null);
        }
        return result.success("成功返回信息", UserDao.selectUserById(User.getUserId()));
    }
}
