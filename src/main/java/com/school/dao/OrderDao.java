package com.school.dao;

import com.school.entity.OrderEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * OrderDao
 */
@Repository
public interface OrderDao {

    // 添加订单
    int InsertOrder(OrderEntity orderEntity) throws Exception;

    // 删除订单
    int DeleteOrder(Long toId) throws Exception;

    // 查询全部订单（动态查询）
    List<OrderEntity> SelectAllOrder(Map params) throws Exception;
}
