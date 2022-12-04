package com.together.date.controller;

import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class registerController {
    @Autowired
    private userService UserService;
    @RequestMapping("/register")
    public result register(@RequestParam(required = false) String identity, @RequestParam(required = false) String userName, @RequestParam(required = false) String avatarUrl, @RequestParam(required = false) String sex, @RequestParam(required = false) String userPwd) {
        registerVo RegisterVo = new registerVo(identity, userName, avatarUrl, sex,100, userPwd);
        result Result = UserService.register(RegisterVo);
        return Result;
    }
}
