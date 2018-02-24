package com.school.service;

import com.school.dao.OrderDao;
import com.school.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * OrderService
 */
@Service("OrderService")
public class OrderService implements IOrderService {
    @Autowired
    private OrderDao orderDao;

    /**
     * 添加订单信息
     **/
    @Override
    @Transactional
    public int InsertOrder(OrderEntity orderEntity) throws Exception {
        return orderDao.InsertOrder(orderEntity);
    }

    /**
     * 删除订单信息
     **/
    @Override
    @Transactional
    public int DeleteOrder(Long toId) throws Exception {
        return orderDao.DeleteOrder(toId);
    }

    /**
     * 查询用户的所有订单信息
     **/
    @Override
    public List<OrderEntity> SelectAllOrder(Map params) throws Exception {
        return orderDao.SelectAllOrder(params);
    }
}
