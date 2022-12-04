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
    public result changeName(@RequestParam(required = false) String tags, @RequestParam(required = false) String id){
        changeVo changeNameVo = new changeVo(tags, id);
        result Result = UserChangeService.changeUserName(changeNameVo.getTags(), changeNameVo.getId());
        return Result;
    }
    @RequestMapping("/change/password")
    public result changePwd(@RequestParam(required = false) String tags, @RequestParam(required = false) String id) {
        changeVo changePwdVo = new changeVo(tags, id);
        result Result = UserChangeService.changeUserPwd(changePwdVo.getTags(), changePwdVo.getId());
        return Result;
    }
    @RequestMapping("/change/sex")
    public result changeSex(@RequestParam(required = false) String tags, @RequestParam(required = false) String id) {
        changeVo changeSexVo = new changeVo(tags, id);
        result Result = UserChangeService.changeUserSex(changeSexVo.getTags(), changeSexVo.getId());
        return Result;
    }
}
