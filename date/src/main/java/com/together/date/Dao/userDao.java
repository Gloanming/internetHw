package com.together.date.Dao;

import com.together.date.Vo.registerVo;
import com.together.date.service.entity.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface userDao {
    void addUser(registerVo RegisterVo) throws DuplicateKeyException;//像数据库中添加用户
    user selectUserById(String Identity);
    void changeUserNameById(String newName,String Id);
    void changeUserSexById(String sex,String Id);
    void changeUserPwdById(String pwd,String Id);
    void changeUserAvatarUrlById(String avatarUrl,String Id);
    void changeUserCredit(String userId, String command);
}
