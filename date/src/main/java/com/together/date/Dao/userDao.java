package com.together.date.Dao;

import com.together.date.Vo.registerVo;
import com.together.date.service.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userDao {
    public void addUser(registerVo RegisterVo) throws DuplicateKeyException;//像数据库中添加用户
    public user selectUserById(String Identity);
}
