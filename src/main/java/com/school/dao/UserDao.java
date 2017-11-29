package com.school.dao;

import com.school.entity.UserEntity;
import org.springframework.stereotype.Repository;

/**
 * UserDao
 */
@Repository
public interface UserDao {

    // 添加用户
    void insertUser(UserEntity userEntity) throws Exception;
    // 删除用户
    void deleteUser(UserEntity userEntity) throws Exception;
    // 修改用户
    void updateUser(UserEntity userEntity) throws Exception;
    // 查询单个用户
    UserEntity selectOneUser(long tuId) throws Exception;
    // 查询全部用户数量
    int selectUserCount() throws Exception;

}
