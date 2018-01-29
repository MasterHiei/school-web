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

    // 查询全部菜单到（动态查询）
    List<CartEntity> SelectAllCart(Map map) throws Exception;
}
