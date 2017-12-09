package com.school.controller;

import com.school.entity.UserEntity;
import com.school.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * UserController
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

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
            if (userEntity.getTiId() == UserEntity.STUDENT_PERMISSION)
                // 学生账户登录
                msg = "1";
            else
                // 管理账户登录
                msg = "2";
        }else {
            // 用户名不匹配时的处理
            msg = "对不起，该账户不存在。";
        }
        return msg;
    }

}
