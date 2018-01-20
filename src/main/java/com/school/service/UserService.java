package com.school.service;

import com.school.dao.UserDao;
import com.school.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserService
 */
@Service("UserService")
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserDao userDao;

    // 添加用户
    @Override
    public int InsertUser(UserEntity userEntity) throws Exception{
        return userDao.InsertUser(userEntity);
    }

    // 删除用户
    @Override
    public int DeleteUser(UserEntity userEntity) throws Exception{
        return userDao.DeleteUser(userEntity);
    }

    // 修改用户
    @Override
    @Transactional
    public int UpdateUser(UserEntity userEntity) throws Exception{
        return userDao.UpdateUser(userEntity);
    }

    // 查询单个用户
    @Override
    public UserEntity SelectOneUser(UserEntity userEntity) throws Exception{
        return userDao.SelectOneUser(userEntity);
    }

    // 查询全部用户
    @Override
    public List<UserEntity> SelectAllUser(UserEntity userEntity) throws Exception{
        return userDao.SelectAllUser(userEntity);
    }

    //查询用户展示名
    public String SelectExhibitor(long tuId) throws Exception{
        return userDao.SelectExhibitor(tuId);
    }

    // 查询全部用户数量
    @Override
    public int SelectUserCount() throws Exception{
        return userDao.SelectUserCount();
    }

}
