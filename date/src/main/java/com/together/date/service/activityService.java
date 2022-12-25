package com.together.date.service;

import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.entity.Activity;

public interface activityService {
    result addActivity(addActivityVo activity);

    result deleteActivity(Activity activity);

    result getUsers(String activityId);
}
