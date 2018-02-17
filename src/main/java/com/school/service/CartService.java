package com.school.service;

import com.school.dao.CartDao;
import com.school.entity.CartEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("CartService")
@Transactional
public class CartService implements ICartService {

    @Autowired
    private CartDao cartDao;

    // 添加购物车
    @Override
    public int InsertCart(CartEntity cartEntity) throws Exception {
        return cartDao.InsertCart(cartEntity);
    }

    // 删除购物车
    @Override
    public int DeleteCart(Long tcId) throws Exception {
        return cartDao.DeleteCart(tcId);
    }

    // 更新购物车
    @Override
    public int UpdateCart(Map map) throws Exception {
        return cartDao.UpdateCart(map);
    }

    // 查询全部购物车（动态查询）
    @Override
    public List<CartEntity> SelectAllCart(Map map) throws Exception {
        return cartDao.SelectAllCart(map);
    }
}
