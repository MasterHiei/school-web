package com.school.controller;

import com.school.entity.CartEntity;
import com.school.entity.DishEntity;
import com.school.entity.UserEntity;
import com.school.service.ICartService;
import com.school.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CartController
 */
@Controller
public class CartController extends BaseController {

    @Autowired
    private ICartService cartService;
    @Autowired
    private IDishService dishService;

    /**
     * 获取用户购物车数量
     */
    @RequestMapping("/selectCartNum")
    @ResponseBody
    public int SelectAllCartNum(HttpSession session)
            throws Exception {

        // 获取session中的用户ID
        Long tuId = Long.parseLong(session.getAttribute(UserEntity.USER_SESSION_ID).toString());

        // 创建参数
        Map params = new HashMap();
        params.put("tuId", tuId);

        // 执行查询
        List<CartEntity> cartEntityList = cartService.SelectAllCart(params);

        // 获取总数量
        int count = 0;
        for (CartEntity data : cartEntityList) {
            count += data.getTcNum();
        }

        return count;
    }

    /**
     * 保存用户购物车信息
     */
    @RequestMapping("/saveCart")
    @ResponseBody
    public String InsertCart(@RequestBody Map map, HttpSession session)
            throws Exception {

        // 日志标题
        String loggerTitle = "InsertCart（保存用户购物车信息）：";

        // 获取Ajax传递的参数
        Long tdId = Long.parseLong(map.get("tdId").toString());
        int tdNum = Integer.parseInt(map.get("tdNum").toString());
        // 获取session中的用户ID
        Long tuId = Long.parseLong(session.getAttribute(UserEntity.USER_SESSION_ID).toString());

        // 创建参数
        Map carParams = new HashMap();
        carParams.put("tuId", tuId);
        carParams.put("tdId", tdId);
        // 查询购物车表中是否已存在该菜单
        List<CartEntity> cartEntityList = cartService.SelectAllCart(carParams);

        if (!cartEntityList.isEmpty()) {
            // 若存在，则更新菜单数量
            // 参数补正
            carParams.put("tcNum", cartEntityList.get(0).getTcNum() + tdNum);
            int result = cartService.UpdateCart(carParams);
            if (result < 1) {
                LOGGER.error(loggerTitle + "购物车信息更新失败。");
                return "false";
            }
        }
        else {
            // 若不存在，则添加新的购物车信息
            // 创建参数
            Map dishParams = new HashMap();
            dishParams.put("tdId", tdId);
            dishParams.put("deleteFlg", DishEntity.DISH_DELETE_FLG_0);
            dishParams.put("start", 0);
            dishParams.put("rows", 1);
            // 获取菜单信息
            List<DishEntity> dishEntityList = dishService.SelectAllDish(dishParams);

            if (!dishEntityList.isEmpty()) {
                // 创建参数
                CartEntity cartEntity = new CartEntity();
                cartEntity.setTcNum(tdNum);
                cartEntity.setTdId(tdId);
                cartEntity.setTuId(tuId);
                // 添加购物车信息
                int result = cartService.InsertCart(cartEntity);
                if (result < 1) {
                    LOGGER.error(loggerTitle + "购物车信息添加失败。");
                    return "false";
                }
            }
            else {
                LOGGER.error(loggerTitle + "菜单信息查询失败。");
                return "false";
            }
        }
        return "true";
    }

    /**
     * 获取用户购物车信息
     */
    @RequestMapping("/selectAllCart")
    @ResponseBody
    public String SelectAllCart(HttpSession session) {

        // 日志标题
        String loggerTitle = "SelectAllCart（查询用户购物车信息）：";

        // 获取session中的用户ID
        Long tuId = Long.parseLong(session.getAttribute(UserEntity.USER_SESSION_ID).toString());

        // 创建参数
        Map params = new HashMap();
        params.put("tuId", tuId);
        
        String jsonStr = "";
        try {
            // 执行查询
            List<CartEntity> cartEntityList = cartService.SelectAllCart(params);

            jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(cartEntityList);
        }
        catch (Exception e) {
            LOGGER.error(loggerTitle + "获取购物车信息失败。");
        }
        return jsonStr;
    }

    /**
     * 更新用户购物车信息
     */
    @RequestMapping("/updateCart")
    @ResponseBody
    public String UpdateCart(@RequestBody Map map)
            throws Exception {

        // 日志标题
        String loggerTitle = "UpdateCart（更新用户购物车信息）：";

        // 获取Ajax传递的参数
        Long tcId = Long.parseLong(map.get("tcId").toString());
        int tcNum = Integer.parseInt(map.get("tcNum").toString());

        // 创建参数
        Map params = new HashMap();
        params.put("tcId", tcId);

        List<CartEntity> cartEntityList = cartService.SelectAllCart(params);

        if (!cartEntityList.isEmpty()) {
            if (tcNum > 0) {
                // 参数补正
                params.put("tcNum", tcNum);
                // 更新数量
                int result = cartService.UpdateCart(params);
                if (result < 1) {
                    LOGGER.error(loggerTitle + "更新购物车信息失败。");
                    return "false";
                }
            }
            else {
                // 删除购物车信息
                int result = cartService.DeleteCart(tcId);
                if (result < 1) {
                    LOGGER.error(loggerTitle + "删除购物车信息失败。");
                    return "false";
                }
            }
        }
        else {
            LOGGER.error(loggerTitle + "获取购物车信息失败。");
            return "false";
        }
        return "true";
    }

    /**
     * 删除用户购物车信息
     */
    @RequestMapping("/deleteCart")
    @ResponseBody
    public String DeleteCart(@RequestBody Map map)
            throws Exception {

        // 日志标题
        String loggerTitle = "DeleteCart（删除用户购物车信息）：";

        // 获取Ajax传递的参数
        String tcIdStr = map.get("tcIdStr").toString();
        // 提取购物车ID
        String[] tcIdArray = tcIdStr.split(",");

        // 根据购物车ID删除购物车信息
        List<String> resultList = new ArrayList<>();
        for (String tcId : tcIdArray) {
            int result = cartService.DeleteCart(Long.parseLong(tcId));
            resultList.add(String.valueOf(result));
        }
        // 检查返回结果集
        if (resultList.contains("0")) {
            LOGGER.error(loggerTitle + "删除购物车信息失败。");
            return "false";
        }
        return "true";
    }
}
