package com.school.dao;

import com.school.entity.DishEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DishDao
 */
@Repository
public interface DishDao {

    // 添加菜单
    int InsertDish(DishEntity dishEntity) throws Exception;

    // 删除菜单
    int DeleteDish(DishEntity dishEntity) throws Exception;

    // 更新菜单
    int UpdateDish(DishEntity dishEntity) throws Exception;

    // 查询全部菜单（动态查询）
    List<DishEntity> SelectAllDish(DishEntity dishEntity) throws Exception;

    // 查询菜单数量
    int SelectDishCount() throws Exception;
}
