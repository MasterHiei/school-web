package com.school.controller;

import com.school.entity.CartEntity;
import com.school.entity.DishEntity;
import com.school.entity.OrderEntity;
import com.school.entity.UserEntity;
import com.school.service.ICartService;
import com.school.service.IDishService;
import com.school.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * OrderController
 */
@Controller
public class OrderController extends BaseController {

    @Autowired
    private ICartService cartService;
    @Autowired
    private IOrderService orderService;

    /**
     * 添加订单信息
     */
    @RequestMapping("/insertOrder")
    @ResponseBody
    public String InsertOrder(HttpSession session)
            throws Exception {

        // 日志标题
        String loggerTitle = "InsertOrder（添加用户订单信息）：";

        // 获取session中保存的用户ID
        Long tuId = Long.parseLong(session.getAttribute(UserEntity.USER_SESSION_ID).toString());
        // 创建参数
        Map params = new HashMap();
        params.put("tuId", tuId);

        // 根据用户ID查询所有购物车信息
        List<CartEntity> cartEntityList = cartService.SelectAllCart(params);

        List<CartEntity> list = new ArrayList<>();
        // 去除包含无货商品的订单
        for (CartEntity item : cartEntityList) {
            if (item.getTdStock().equals("有货")) {
                list.add(item);
            }
        }

        if (!list.isEmpty()) {
            // 根据购物车信息生成订单
            OrderEntity orderEntity = new OrderEntity();

            for (CartEntity item : list) {
                // 订单数量
                orderEntity.setToNum(item.getTcNum());
                // 订单金额
                double totalPrice = Double.parseDouble(item.getTdPrice()) * (double) item.getTcNum();
                orderEntity.setToPrice(String.valueOf(totalPrice));
                // 用户ID
                orderEntity.setTuId(tuId);
                // 菜单名称
                orderEntity.setTdName(item.getTdName());
                // 订单状态
                orderEntity.setStatusFlg(OrderEntity.ORDER_STATUS_FLG_0); // 未受理
                // 删除flag
                orderEntity.setDeleteFlg(OrderEntity.ORDER_DELETE_FLG_0); // 未删除

                // 生成订单
                try {
                    int insertRet = orderService.InsertOrder(orderEntity);
                    if (insertRet == 1) {
                        // 删除购物车信息
                        int deleteRet = cartService.DeleteCart(item.getTcId());
                        if (deleteRet < 1) {
                            LOGGER.error(loggerTitle + "删除购物车信息失败。");
                            return "false";
                        }
                    }
                    else {
                        LOGGER.error(loggerTitle + "订单信息创建失败。");
                        return "false";
                    }
                }
                catch (Exception ex) {
                    LOGGER.error(loggerTitle + "订单信息创建失败。");
                    return "false";
                }
            }
        }
        else {
            return "alert";
        }

        return "true";
    }
}
