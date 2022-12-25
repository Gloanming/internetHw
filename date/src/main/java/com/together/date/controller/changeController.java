package com.together.date.controller;

import com.together.date.Vo.ChangeNameVo;
import com.together.date.Vo.changePwdVo;
import com.together.date.Vo.changeVo;
import com.together.date.result.result;
import com.together.date.service.entity.user;
import com.together.date.service.userChangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class changeController {
    @Autowired
    userChangeService UserChangeService;

    user User;
    @RequestMapping("/change/Name")
    public result changeName(@RequestBody(required = false) changeVo changeNameVo){

        result Result = UserChangeService.changeUserName(changeNameVo.getTags(), changeNameVo.getId());
        return Result;
    }
    @RequestMapping("/change/password")
    public result changePwd(@RequestBody(required = false) changeVo changePwdVo){
        result Result = UserChangeService.changeUserPwd(changePwdVo.getTags(), changePwdVo.getId());
        return Result;

    }
    @RequestMapping("/change/sex")
    public result changeSex(@RequestBody(required = false) changeVo changeSexVo) {
        result Result = UserChangeService.changeUserSex(changeSexVo.getTags(), changeSexVo.getId());
        return Result;
    }
}
