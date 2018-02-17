package com.school.service;

import com.school.entity.CartEntity;
import com.school.entity.OrderEntity;

import java.util.List;
import java.util.Map;

/**
 * IOrderService
 */
public interface IOrderService {
    /**
     * 添加订单信息
     **/
    int InsertOrder(OrderEntity orderEntity) throws Exception;

    /**
     * 删除订单信息
     **/
    int DeleteOrder(Long toId) throws Exception;

    /**
     * 查询用户的所有订单信息
     **/
    List<OrderEntity> SelectAllOrder(Map params) throws Exception;
}
