package com.school.service;

import com.school.dao.UserDao;
import com.school.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * UserService
 */
@Service("UserService")
@Transactional
public class UserService implements UserServiceImpl {

    @Autowired
    private UserDao userDao;

    // 添加用户
    @Override
    public void insertUser(UserEntity userEntity) throws Exception{
        userDao.insertUser(userEntity);
    }

    // 删除用户
    @Override
    public void deleteUser(UserEntity userEntity) throws Exception{
        userDao.deleteUser(userEntity);
    }

    // 修改用户
    @Override
    @Transactional
    public void updateUser(UserEntity userEntity) throws Exception{
        userDao.updateUser(userEntity);
    }

    // 查询单个用户
    @Override
    public UserEntity selectOneUser(long tuId) throws Exception{
        UserEntity userEntity = userDao.selectOneUser(tuId);
        System.out.println(userEntity);
        return userEntity;
    }

    // 查询全部用户数量
    @Override
    public int selectUserCount() throws Exception{
        return userDao.selectUserCount();
    }

}
