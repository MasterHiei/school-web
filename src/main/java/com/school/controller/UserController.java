package com.school.controller;

import com.school.entity.UserEntity;
import com.school.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
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
    public Map<String, Object> selectOneUser(HttpServletRequest request, HttpSession session)
            throws Exception{

        // 获取Ajax传递的参数
        String tuName = request.getParameter("tuName"),
                tuPwd = request.getParameter("tuPwd");

        Map<String, Object> map = new HashMap<>();

        // 查询单个用户
        UserEntity userEntity = userService.selectOneUser(tuName.trim());

        if (userEntity != null){
            // 密码不匹配时的处理
            if (!userEntity.getTuPwd().equals(tuPwd.trim())){
                map.put("msg", "对不起，您输入的密码不正确。");
            }
            // 正常处理
            // step1. 保存查询到的用户信息
            session.setAttribute(UserEntity.USER_SESSION, userEntity);
            // step2. 返回"1"(success)
            map.put("msg", "1");
        }else {
            // 用户名不匹配时的处理
            map.put("msg", "对不起，该账户不存在。");
        }
        return map;
    }

}
