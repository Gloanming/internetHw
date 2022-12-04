package com.together.date.controller;

import com.together.date.Vo.loginVo;
import com.together.date.result.result;
import com.together.date.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController

public class loginController {
    @Autowired
    private userService UserService;
    @RequestMapping("/login")
    public result login(@RequestParam(required = false, value = "identity") String identity, @RequestParam(required = false) String pwd) {

        loginVo LoginVo = new loginVo(identity, pwd);
        result Result = UserService.login(LoginVo);
        return Result;
    }


}
