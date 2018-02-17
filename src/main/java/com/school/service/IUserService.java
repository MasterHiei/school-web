package com.school.service;

import com.school.entity.UserEntity;

import java.util.List;

/**
 * IUserService
 */
public interface IUserService {

    /**
     * 添加用户信息
     **/
    int InsertUser(UserEntity userEntity) throws Exception;

    /**
     * 添加用户信息
     **/
    int DeleteUser(UserEntity userEntity) throws Exception;

    /**
     * 更新用户信息
     **/
    int UpdateUser(UserEntity userEntity) throws Exception;

    /**
     * 查询用户信息
     **/
    UserEntity SelectOneUser(UserEntity userEntity) throws Exception;

    /**
     * 查询所有用户信息
     **/
    List<UserEntity> SelectAllUser(UserEntity userEntity) throws Exception;

    /**
     * 查询用户名
     **/
    String SelectExhibitor(long tuId) throws Exception;

    /**
     * 查询用户数量
     **/
    int SelectUserCount() throws Exception;

}
