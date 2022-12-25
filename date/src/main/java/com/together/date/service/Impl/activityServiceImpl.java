package com.together.date.service.Impl;

import com.together.date.Dao.activityDao;
import com.together.date.Dao.dateDao;
import com.together.date.Dao.userDao;
import com.together.date.Vo.addActivityVo;
import com.together.date.result.result;
import com.together.date.service.activityService;
import com.together.date.service.entity.Activity;
import com.together.date.service.entity.user;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class activityServiceImpl implements activityService {

    @Autowired
    activityDao acDao;

    @Autowired
    dateDao DateDao;
    @Autowired
    userDao UserDao;
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
        List<user> userList = new ArrayList<>();
        for (int i = 0; i < Users.size(); i++) {
            user userInformation = UserDao.selectUserById(Users.get(i));
            userList.add(userInformation);
        }
        return result.success("参与者列表", userList);
    }


    public result searchByCreatorId(String id) {
       List<Activity> activities = acDao.searchByCreatorId(id);
       if (activities == null) {
           return result.fail("找不到该用户创建的活动", (Object) null);
       }
       return result.success("成功找到该用户创建的活动", activities);
    }

    public result searchByType(String type) {
        List<Activity> activities = acDao.searchByType(type);
        if (activities == null) {
            return result.fail("找不到该类型创建的活动", (Object) null);
        }
        return result.success("成功找到该类型的活动", activities);
    }

    public result searchByLike() {
        List<Activity> activities = acDao.searchByLike();
        if (activities == null) {
            return result.fail("找不到活动", (Object) null);
        }
        return result.success("成功找到活动", activities);
    }

    public result searchByView() {
        List<Activity> activities = acDao.searchByView();
        if (activities == null) {
            return result.fail("找不到活动", (Object) null);
        }
        return result.success("成功找到活动", activities);
    }

    public result searchByActivityId(int id) {
        List<Activity> activities = acDao.searchByActivityId(id);
        if (activities == null) {
            return result.fail("找不到活动", (Object) null);
        }
        return result.success("成功找到活动", activities);
    }

    public result addLike(int id) {
        acDao.addLike(id);
        return result.success("点赞成功",acDao.searchByActivityId(id));
    }

    public result cancelLike(int id) {
        acDao.cancelLike(id);
        return result.success("取消点赞成功",acDao.searchByActivityId(id));
    }
}
