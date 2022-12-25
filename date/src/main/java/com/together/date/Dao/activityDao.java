package com.together.date.Dao;


import com.together.date.Vo.addActivityVo;
import com.together.date.service.entity.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface activityDao {
    //创建活动
//    public void addActivity(int creatorId, int activityId, String activityType, String head, String content,
//                            String startTime, String endTime, int viewCount, int capacity, int bookCount, int likeCount);
    public void addActivity(addActivityVo activityVo);

    //删除活动
    public void deleteActivity(String activityId);

    //查询活动
    public List<Activity> searchByType(String searchType);//根据类型查询
    public List<Activity> searchByCreatorId(String creatorId);//根据创建人ID查询
    public List<Activity> searchByView();//根据浏览量查询
    public List<Activity> searchByLike();//根据点赞数查询

}
