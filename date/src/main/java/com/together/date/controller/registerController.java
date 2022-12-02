package com.together.date.controller;

import com.together.date.Vo.registerVo;
import com.together.date.result.result;
import com.together.date.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class registerController {
    @Autowired
    private userService UserService;
    @RequestMapping("/register")
    public result register(@RequestBody(required = false) registerVo RegisterVo) {
        result Result = UserService.register(RegisterVo);
        return Result;
    }
}
