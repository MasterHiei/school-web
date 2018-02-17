package com.school.service;

import com.school.entity.DishEntity;

import java.util.List;
import java.util.Map;

/**
 * IDishService
 */
public interface IDishService {

    /**
     * 添加菜单信息
     **/
    int InsertDish(DishEntity dishEntity) throws Exception;

    /**
     * 删除菜单信息
     **/
    int DeleteDish(DishEntity dishEntity) throws Exception;

    /**
     * 更新菜单信息
     **/
    int UpdateDish(DishEntity dishEntity) throws Exception;

    /**
     * 查询所有菜单信息
     **/
    List<DishEntity> SelectAllDish(Map params) throws Exception;

    /**
     * 查询菜单数量
     **/
    int SelectDishCount(Map params) throws Exception;
}
