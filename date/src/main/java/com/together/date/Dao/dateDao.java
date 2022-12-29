package com.together.date.Dao;

import com.together.date.service.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface dateDao {
    void someoneDate(int activityId, String userId);
    List<String> getUsers(int activityId);
}
