package com.together.date.service.Impl;

import com.together.date.Dao.activityDao;
import com.together.date.Dao.dateDao;
import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.activityService;
import com.together.date.service.entity.Activity;
import com.together.date.service.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class activityServiceImpl implements activityService {

    @Autowired
    activityDao acDao;

    @Autowired
    dateDao DateDao;
    @Override
    public result addActivity(addActivityVo act) {
//        acDao.addActivity(act.getCreatorId(), act.getActivityId(), act.getActivityType(), act.getHead(), act.getContent(), act.getStartTime(), act.getEndTime(), act.getViewCount(), act.getCapacity(), act.getBookCount(), act.getLikeCount());
        acDao.addActivity(act);
        return result.success("成功添加活动", acDao.searchByCreatorId(act.getCreatorId()));
    }

    @Override
    public result deleteActivity(Activity act) {
        acDao.deleteActivity(act.getActivityId());
        return result.success("成功删除活动", acDao.searchByCreatorId(act.getCreatorId()));
    }
    @Override
    public result getUsers(String activityId) {

        List<String> Users = DateDao.getUsers(activityId);
        if (Users == null) {
            return result.fail("没有信息",null);
        }
        return result.success("参与者列表", Users);
    }


}
