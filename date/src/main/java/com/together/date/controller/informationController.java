package com.together.date.controller;

import com.together.date.Dao.userDao;
import com.together.date.Vo.ChangeNameVo;
import com.together.date.Vo.changePwdVo;
import com.together.date.Vo.changeVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;
import com.together.date.service.userChangeService;
import com.together.date.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class informationController {

    @Autowired
    private userService UserService;
    @Autowired
    userDao UserDao;
    @RequestMapping("/information")
    public result getUserInformation(@RequestParam(required = false) String userId) {
        user User = UserDao.selectUserById(userId);
        result Result = UserService.getInformation(User);
        return Result;
    }
}
