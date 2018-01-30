package com.school.dao;

import com.school.entity.CartEntity;
import com.school.entity.DishEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * CartDao
 */
@Repository
public interface CartDao {

    // 添加菜单
    int InsertCart(CartEntity cartEntity) throws Exception;

    // 删除菜单
    int DeleteCart(Long tcId) throws Exception;

    // 更新菜单
    int UpdateCart(Map map) throws Exception;

    // 查询全部菜单（单一用户的所有菜单信息）
    List<CartEntity> SelectAllCart(Map map) throws Exception;
}
