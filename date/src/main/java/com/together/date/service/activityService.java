package com.together.date.service;

import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.entity.Activity;

public interface activityService {
    result addActivity(addActivityVo activity);

    result deleteActivity(Activity activity);


    result getUsers(int activityId);

    result searchByCreatorId(String id);

    result searchByType(String type);

    result searchByLike();

    result searchByView();

    result searchByActivityId(String id);

    result addLike(String id);

    result cancelLike(String id);

}
