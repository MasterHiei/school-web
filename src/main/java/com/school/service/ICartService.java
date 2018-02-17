package com.school.service;

import com.school.entity.CartEntity;

import java.util.List;
import java.util.Map;

/**
 * ICartService
 */
public interface ICartService {
    /**
     * 添加购物车信息
     **/
    int InsertCart(CartEntity cartEntity) throws Exception;

    /**
     * 删除购物车信息
     **/
    int DeleteCart(Long tcId) throws Exception;

    /**
     * 更新购物车信息（数量）
     * @param map 更新条件
     *            exp.
     *            param = {用户ID: tuId, 菜单ID: tdId}
     *                      or {购物车ID: tcId}
     * @return int 执行结果
     **/
    int UpdateCart(Map map) throws Exception;

    /**
     * 查询用户所有购物车信息
     * @param map 查询条件
     *            exp.
     *            param = {用户ID: tuId, 菜单ID: tdId}
     *                      or {购物车ID: tcId}
     * @return List<CartEntity> 购物车信息集合
     **/
    List<CartEntity> SelectAllCart(Map map) throws Exception;
}
