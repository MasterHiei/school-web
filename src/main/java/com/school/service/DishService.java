package com.school.service;

import com.school.dao.DishDao;
import com.school.entity.DishEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * DishService
 */
@Service("DishService")
@Transactional
public class DishService implements IDishService {

    @Autowired
    private DishDao dishDao;

    @Override
    public int InsertDish(DishEntity dishEntity) throws Exception {
        return dishDao.InsertDish(dishEntity);
    }

    @Override
    public int DeleteDish(DishEntity dishEntity) throws Exception {
        return dishDao.DeleteDish(dishEntity);
    }

    @Override
    public int UpdateDish(DishEntity dishEntity) throws Exception {
        return dishDao.UpdateDish(dishEntity);
    }

    @Override
    public List<DishEntity> SelectAllDish(Map params) throws Exception {
        return dishDao.SelectAllDish(params);
    }

    @Override
    public int SelectDishCount(Map params) throws Exception {
        return dishDao.SelectDishCount(params);
    }
}
