package com.together.date.service.Impl;

import com.together.date.Dao.activityDao;
import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.activityService;
import com.together.date.service.entity.Activity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class activityServiceImpl implements activityService {

    @Autowired
    activityDao acDao;



    @Override
    public result addActivity(addActivityVo act) {
//        acDao.addActivity(act.getCreatorId(), act.getActivityId(), act.getActivityType(), act.getHead(), act.getContent(), act.getStartTime(), act.getEndTime(), act.getViewCount(), act.getCapacity(), act.getBookCount(), act.getLikeCount());
        acDao.addActivity(act);
        return result.success("成功添加活动");
    }

    @Override
    public result deleteActivity(Activity act) {
        acDao.deleteActivity(act.getActivityId());
        return result.success("成功删除活动");
    }

}
