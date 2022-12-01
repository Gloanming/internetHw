package com.together.date.controller;

import com.together.date.Vo.loginVo;
import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.userService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController

public class loginController {
    @Autowired
    private userService UserService;
    @RequestMapping("/login")
    public result login(@RequestBody(required = false) loginVo LoginVo) {
        result Result = UserService.login(LoginVo);
        return Result;
    }


}
