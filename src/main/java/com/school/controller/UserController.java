package com.school.controller;

import com.school.entity.ExhibitionEntity;
import com.school.entity.UserEntity;
import com.school.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * UserController
 */
@Controller
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    /**
     * 登录处理
     * 拦截器验证通过后才会执行
     */
    @RequestMapping("/validSession")
    @ResponseBody
    public String ValidSession(HttpSession session) {
        // 返回session值（tuName）
        String result = "login" + ","
                + session.getAttribute(UserEntity.USER_SESSION_ID).toString() + ","
                + session.getAttribute(UserEntity.USER_SESSION_NAME).toString();
        return result;
    }

    /**
     * 注销处理
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String Logout(HttpSession session) {
        // 销毁session
        session.invalidate();
        return "logout";
    }

    /**
     * 用户登录
     */
    @RequestMapping("/login")
    @ResponseBody
    public String Login(@RequestBody Map map, HttpSession session)
            throws Exception{

        // 获取Ajax传递的参数
        String tuName = map.get("tuName").toString(),
                tuPwd = map.get("tuPwd").toString(),
                // 创建返回值
                msg;

        // 参数赋值
        UserEntity params = new UserEntity();
        params.setTuName(tuName);
        params.setDeleteFlg(UserEntity.USER_DELETE_FLG_0);

        // 查询单个用户
        UserEntity userEntity = userService.SelectOneUser(params);

        if (userEntity != null){
            // 密码不匹配时的处理
            if (!userEntity.getTuPwd().equals(tuPwd)){
                msg = "invalid";
                return msg;
            }
            // 正常处理
            // step1. 保存查询到的用户信息
            session.setAttribute(UserEntity.USER_SESSION_ID, userEntity.getTuId());
            session.setAttribute(UserEntity.USER_SESSION_NAME, userEntity.getTuName());
            // step2. 判断用户身份
            if (userEntity.getTiId() == UserEntity.STUDENT_PERMISSION){
                // 学生账户登录
                msg = "student";
            }else {
                // 管理账户登录
                msg = "admin";
            }
        }else {
            // 用户名不匹配时的处理
            msg = "null";
        }
        return msg;
    }

    /**
     * 用户注册
     */
    @RequestMapping("/register")
    @ResponseBody
    public String Register(@RequestBody UserEntity userEntity) throws Exception{

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
            userEntity.setDeleteFlg(UserEntity.USER_DELETE_FLG_0);

            // 添加用户
            int result = userService.InsertUser(userEntity);

            if (result == 1){
                // 添加成功时的处理
                msg = "true";
            }else {
                // 添加失败时的处理
                msg = "false";
            }
        }else {
            msg = "false";
        }
        return msg;
    }

    /**
     * 查询用户名是否存在
     */
    @RequestMapping("/selectUserName")
    @ResponseBody
    public String SelectUserName(@RequestBody Map map)
            throws Exception{

        // 获取Ajax传递的参数
        String tuName = map.get("tuName").toString(),
                // 创建返回值
                msg;

        // 参数赋值
        UserEntity params = new UserEntity();
        params.setTuName(tuName);
        params.setDeleteFlg(UserEntity.USER_DELETE_FLG_0);

        // 查询单个用户
        UserEntity userEntity = userService.SelectOneUser(params);

        if (userEntity == null){
            // 正常处理
            msg = "true";
        }else {
            // 用户名已被使用时的处理
            msg = "false";
        }
        return msg;
    }

    /**
     * 查询用户展示名
     */
    @RequestMapping("/selectExhibitor")
    @ResponseBody
    public String selectExhibitor() throws Exception{

        // 获取所有餐厅用户
        UserEntity params = new UserEntity();
        params.setTiId(UserEntity.CANTEEN_PERMISSION);
        List<UserEntity> userEntityList = userService.SelectAllUser(params);

        // 根据获取到的饭厅用户列表取得其对应的展示名
        List<ExhibitionEntity> exhibitionEntityList = new ArrayList<>();
        if (!userEntityList.isEmpty()){
            for (int i = 0; i < userEntityList.size(); i++){
                long tuId = userEntityList.get(i).getTuId();
                // 获取展示名
                String teName = userService.SelectExhibitor(tuId);
                // 将展示名存入List集合中
                ExhibitionEntity exhibitionEntity = new ExhibitionEntity();
                exhibitionEntity.setTuId(tuId);
                exhibitionEntity.setTeName(teName);
                exhibitionEntityList.add(exhibitionEntity);
            }
            // 将List类型转换成Json字符串，并作为返回值传递给前台
            String jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(exhibitionEntityList);
            return jsonStr;
        }
        return "";
    }

    /**
     * 查询单个用户信息
     */
    @RequestMapping("/selectOneUser")
    @ResponseBody
    public String SelectOneUser(HttpSession session) throws Exception{

        // 日志标题
        final String LOGGER_TITLE = "SelectOneUser（查询用户信息）：";

        UserEntity params = new UserEntity();
        // 从session中获取用户名
        params.setTuName(session.getAttribute(UserEntity.USER_SESSION_NAME).toString());
        params.setDeleteFlg(UserEntity.USER_DELETE_FLG_0);

        UserEntity user = new UserEntity();
        // 执行查询
        try {
            user = userService.SelectOneUser(params);
        }
        catch (Exception ex) {
            LOGGER.error(LOGGER_TITLE + "用户信息查询失败。");
        }

        String jsonStr = "";

        if (user != null) {
            jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(user);
        }

        return jsonStr;
    }

    /**
     * 修改用户信息
     */
    @RequestMapping("/updateUser")
    @ResponseBody
    public String UpdateUser(@RequestBody Map map)
            throws Exception{

        // 日志标题
        final String LOGGER_TITLE = "UpdateUser（修改用户信息）：";

        // 获取AJAX传递的参数
        UserEntity params = new UserEntity();
        params.setTuId(Long.parseLong(map.get("tuId").toString()));
        params.setTuPwd(map.get("tuPwd").toString());
        params.setTuAddress(map.get("tuAddress").toString());

        String result = null;
        try {
            // 执行更新
            int ret = userService.UpdateUser(params);

            if (ret > 0) {
                result = "true";
            }
            else {
                result = "false";
                throw new Exception("");
            }
        } catch (Exception ex) {
            LOGGER.error(LOGGER_TITLE + "用户信息修改失败。");
        }
        return result;
    }
}
