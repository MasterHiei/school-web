package com.school.dao;

import com.school.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserDao
 */
@Repository
public interface UserDao {

    // 添加用户
    int InsertUser(UserEntity userEntity) throws Exception;
    // 删除用户
    int DeleteUser(UserEntity userEntity) throws Exception;
    // 修改用户
    int UpdateUser(UserEntity userEntity) throws Exception;
    // 查询单个用户
    UserEntity SelectOneUser(UserEntity userEntity) throws Exception;
    //查询全部用户
    List<UserEntity> SelectAllUser(UserEntity userEntity) throws Exception;
    //查询用户展示名
    String SelectExhibitor(@Param("tuId") long tuId) throws Exception;
    // 查询全部用户数量
    int SelectUserCount() throws Exception;

}
