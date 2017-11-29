package com.school.controller;

import com.school.entity.UserEntity;
import com.school.service.UserService;
import com.school.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * UserController
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public ModelAndView selectOneUser(@RequestParam("tuId") String tuId,
                                      @RequestParam("tuPwd") String tuPwd, HttpSession httpSession)
            throws Exception{

        ModelAndView mav = new ModelAndView();

        // 查询单个用户
        UserEntity userEntity = userService.selectOneUser(Long.parseLong(tuId.trim()));

        if (userEntity != null){

            // 密码不匹配时的处理
            if (!userEntity.getTuPwd().equals(tuPwd.trim())){
                mav.addObject("errorMsg", "对不起，您输入的密码不正确。");
                mav.setViewName("forward:/login.jsp");
            }

            // 保存查询到的用户信息
            httpSession.setAttribute(UserEntity.USER_SESSION, userEntity);
        }else {
            // 用户名不匹配时的处理
            mav.addObject("errorMsg", "对不起，该账户不存在。");
            mav.setViewName("forward:/login.jsp");
        }

        return mav;
    }

}
