package com.school.controller;

import com.school.entity.CartEntity;
import com.school.entity.DishEntity;
import com.school.entity.UserEntity;
import com.school.service.ICartService;
import com.school.service.IDishService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CartController
 */
@Controller
public class CartController {

    @Autowired
    ICartService cartService;
    @Autowired
    IDishService dishService;

    private Logger logger = Logger.getLogger(CartController.class);

    /**
     * 登录处理
     * 拦截器验证通过后才会执行
     */
    @RequestMapping("/saveCart")
    @ResponseBody
    public void InsertCart(@RequestBody Map map, HttpSession session)
            throws Exception {

        String className = Thread.currentThread().getStackTrace()[1].getClassName();

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
                writerLog(className, "购物车信息更新失败。");
            }
        }
        else {
            // 若不存在，则添加新的购物车信息
            // 创建参数
            Map dishParams = new HashMap();
            dishParams.put("tdId", tdId);
            dishParams.put("deleteFlg", DishEntity.DISH_DELETE_0);
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
                    writerLog(className, "购物车信息添加失败。");
                }
            }
            else {
                writerLog(className, "菜单信息查询失败。");
            }
        }
    }

    public void writerLog(String className, String message) {
        logger.error(className + "： " + message);
    }
}
