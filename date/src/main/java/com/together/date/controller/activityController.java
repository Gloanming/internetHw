package com.together.date.controller;


import com.together.date.Dao.activityDao;
import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.activityService;
import com.together.date.service.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public result activityByCreatorId(@RequestParam(required = false) String id){
        return ActivityService.searchByCreatorId(id);
    }

    @RequestMapping("/types")
    public result activityByType(@RequestParam(required = false) String type){
        return ActivityService.searchByType(type);
    }

    @RequestMapping("/like")
    public result activityByLike(){
        return ActivityService.searchByLike();
    }

    @RequestMapping("/view")
    public result activityByView(){
        return ActivityService.searchByView();
    }

    @RequestMapping("/activityId")
    public result activityById(@RequestBody(required = false) String id) {
        return ActivityService.searchByActivityId(id);
    }

    @RequestMapping("/addLike")
    public result addLike(@RequestBody(required = false) String id) {
        return ActivityService.addLike(id);
    }

    @RequestMapping("/cancelLike")
    public result cancelLike(@RequestBody(required = false) String id) {
        return ActivityService.cancelLike(id);
    }
}

