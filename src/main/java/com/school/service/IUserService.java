package com.school.service;

import com.school.entity.UserEntity;

/**
 * IUserService
 */
public interface IUserService {

    // 添加用户
    int InsertUser(UserEntity userEntity) throws Exception;
    // 删除用户
    int DeleteUser(UserEntity userEntity) throws Exception;
    // 修改用户
    int UpdateUser(UserEntity userEntity) throws Exception;
    // 查询单个用户
    UserEntity SelectOneUser(UserEntity userEntity) throws Exception;
    // 查询全部用户数量
    int SelectUserCount() throws Exception;

}
