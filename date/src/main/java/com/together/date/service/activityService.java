package com.together.date.service;

import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.entity.Activity;

public interface activityService {
    result addActivity(addActivityVo activity);

    result deleteActivity(Activity activity);

<<<<<<< HEAD
    result getUsers(String activityId);
=======
    result searchByCreatorId(String id);

    result searchByType(String type);

    result searchByLike();

    result searchByView();

    result searchByActivityId(int id);

    result addLike(int id);

    result cancelLike(int id);
>>>>>>> 86da5eabbe58ad4728b87ce80a1b17fd06271f45
}
