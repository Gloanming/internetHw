package com.together.date.controller;

import com.together.date.Vo.ChangeNameVo;
import com.together.date.Vo.changePwdVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;
import com.together.date.service.userChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class changeController {
    @Autowired
    userChangeService UserChangeService;

    user User;
    @RequestMapping("/change/Name")
    public result changeName(@RequestBody(required = false) ChangeNameVo changeNameVo){

        result Result = UserChangeService.changeUserName(changeNameVo.getName(), changeNameVo.getId());
        return Result;
    }
    @RequestMapping("/change/password")
    public result changePwd(@RequestBody(required = false)changePwdVo ChangeNameVo) {
        result Result = UserChangeService.changeUserPwd(ChangeNameVo.getNewPwd(), ChangeNameVo.getId());
        return Result;
    }
}
