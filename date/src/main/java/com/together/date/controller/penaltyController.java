package com.together.date.controller;

import com.together.date.Vo.creditVo;
import com.together.date.result.result;
import com.together.date.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class penaltyController {
    @Autowired
    private userService UserService;
    @RequestMapping("/penalty")
    public result penalty(@RequestParam(required = false) String userId, @RequestParam(required = false) int thisUserCredit, @RequestParam(required = false) String command) {
        creditVo CreditVo = new creditVo(userId, thisUserCredit, command);
        result Result = UserService.breakRule(CreditVo);
        return Result;
    }


}
