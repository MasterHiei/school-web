package com.school.service;

import com.school.entity.CartEntity;

import java.util.List;
import java.util.Map;

/**
 * ICartService
 */
public interface ICartService {
    // 添加菜单
    int InsertCart(CartEntity cartEntity) throws Exception;

    // 删除菜单
    int DeleteCart(Long tcId) throws Exception;

    // 更新菜单
    int UpdateCart(Map map) throws Exception;

    /**
     * 查询用户的所有购物车信息
     * @param map 查询条件
     *            exp.
     *            param = {用户ID: tuId, 菜单ID: tdId}
     * @return List<CartEntity> 购物车信息集合
     **/
    List<CartEntity> SelectAllCart(Map map) throws Exception;
}
