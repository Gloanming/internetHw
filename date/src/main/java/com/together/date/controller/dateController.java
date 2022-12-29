package com.together.date.controller;

import com.together.date.Vo.activity_participantVo;
import com.together.date.Vo.loginVo;
import com.together.date.result.result;
import com.together.date.service.activityService;
import com.together.date.service.entity.Activity;
import com.together.date.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping
@RestController
public class dateController {
    @Autowired
    userService UserService;
    @Autowired
    activityService ActivityService;
    @RequestMapping("/date")
    public result date(@RequestBody(required = false)activity_participantVo activityParticipantVo) {
        result Result = UserService.date(activityParticipantVo);
        return Result;
    }
    @RequestMapping("/getUsers")
    public result getUsers(@RequestParam(required = false)int activityId) {
        result Result = ActivityService.getUsers(activityId);
        return Result;
    }
}
