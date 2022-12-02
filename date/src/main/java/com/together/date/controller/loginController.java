package com.together.date.controller;

import com.together.date.Vo.loginVo;
import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.userService;
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
    public result login(@RequestBody loginVo LoginVo) {
        result Result = UserService.login(LoginVo);
        return Result;
    }
    public result register(@RequestBody registerVo RegisterVo) {
        result Result = UserService.register(RegisterVo);
        return Result;
    }
}
