package com.together.date.controller;


import com.together.date.Dao.activityDao;
import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.activityService;
import com.together.date.service.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping
@RestController
public class activityController {

    @Autowired
    private activityService ActivityService;

    @Autowired
    private activityDao ActivityDao;

    @RequestMapping("/addActivity")
    public result addActivity(@RequestBody addActivityVo activity){
        return ActivityService.addActivity(activity);
    }

    @RequestMapping("/delActivity")
    public result delActivity(@RequestBody Activity activity){
        return ActivityService.deleteActivity(activity);
    }

    @RequestMapping("/idRetrieve")
    public List<Activity> activityByCreatorId(@RequestBody String id){
        return ActivityDao.searchByCreatorId(id);
    }

    @RequestMapping("/types")
    public List<Activity> activityByType(@RequestBody String type){
        return ActivityDao.searchByType(type);
    }

    @RequestMapping("/like")
    public List<Activity> activityByLike(){
        return ActivityDao.searchByLike();
    }

    @RequestMapping("/view")
    public List<Activity> activityByView(){
        return ActivityDao.searchByView();
    }

}

