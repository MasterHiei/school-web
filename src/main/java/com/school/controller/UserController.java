package com.school.controller;

import com.school.entity.UserEntity;
import com.school.service.UserService;
import com.school.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * UserController
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public String selectOneUser(@RequestBody Map map, HttpSession session)
            throws Exception{

        // 获取Ajax传递的参数
        String tuName = map.get("tuName").toString(),
                tuPwd = map.get("tuPwd").toString(),
                // 创建返回值
                msg;

        // 查询单个用户
        UserEntity userEntity = userService.selectOneUser(tuName);

        if (userEntity != null){
            // 密码不匹配时的处理
            if (!userEntity.getTuPwd().equals(tuPwd)){
                msg = "对不起，您输入的密码不正确。";
                return msg;
            }
            // 正常处理
            // step1. 保存查询到的用户信息
            session.setAttribute(UserEntity.USER_SESSION, userEntity);
            // step2. 判断用户身份
            if (userEntity.getTiId() == UserEntity.STUDENT_PERMISSION){
                // 学生账户登录
                msg = "1";
            }else {
                // 管理账户登录
                msg = "2";
            }
        }else {
            // 用户名不匹配时的处理
            msg = "对不起，该账户不存在。";
        }
        return msg;
    }

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public String insertUser(@RequestBody UserEntity userEntity) throws Exception{

        String msg;

        if (userEntity != null){
            // 补充用户信息
            // 1.日期
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(new Date());
            Timestamp timestamp = Timestamp.valueOf(time);
            userEntity.setTuDate(timestamp);
            // 2.用户身份
            userEntity.setTiId(UserEntity.STUDENT_PERMISSION);
            // 3.激活状态
            userEntity.setDeleteFlg(UserEntity.USER_DELETE_0);

            // 添加用户
            int result = userService.insertUser(userEntity);

            if (result != 0){
                // 添加成功时的处理
                msg = "1";
            }else {
                // 添加失败时的处理
                msg = "创建账户时发生未知错误，请重新注册。";
            }
        }else {
            msg = "创建账户时发生未知错误，请重新注册。";
        }
        return msg;
    }

    /**
     * 查询用户名是否存在
     */
    @RequestMapping("/userName")
    @ResponseBody
    public String selectOneUser(@RequestBody Map map)
            throws Exception{

        // 获取Ajax传递的参数
        String tuName = map.get("tuName").toString(),
                // 创建返回值
                msg;

        // 查询单个用户
        UserEntity userEntity = userService.selectOneUser(tuName);

        if (userEntity == null){
            // 正常处理
            msg = "1";
        }else {
            // 用户名已被使用时的处理
            msg = "用户名已存在。";
        }
        return msg;
    }
}
