package com.school.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.school.entity.DishEntity;
import com.school.service.IDishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * DishController
 */
@Controller
public class DishController {

    @Autowired
    private IDishService dishService;

    /**
     * 菜品数量查询
     */
    @RequestMapping("/selectDishCount")
    @ResponseBody
    public int SelectDishCount(@RequestBody Map<String, String> map)
            throws Exception{

        // 创建参数
        Map params = new HashMap();
        //获取AJAX传递的并赋值给params
        for (Map.Entry<String, String> entry : map.entrySet()){
            params.put(entry.getKey(), entry.getValue().trim());
        }
        // 参数补正
        params.put("deleteFlg", DishEntity.DISH_DELETE_0); // 未删除

        // 从数据库中获取满足当前条件的数据总数
        int rows = dishService.SelectDishCount(params);

        if (rows > 0){
            return rows;
        }
        else {
            return 0;
        }
    }

    /**
     * 菜品查询（通用）
     */
    @RequestMapping("/selectAllDish")
    @ResponseBody
    public String SelectAllDish(@RequestBody Map<String, Object> map)
            throws Exception{

        // 创建参数
        Map params = new HashMap();
        //获取AJAX传递的并赋值给params
        for (Map.Entry<String, Object> entry : map.entrySet()){
            params.put(entry.getKey(), entry.getValue());
        }

        // 处理other类型参数
        JSONObject jsonObject = JSON.parseObject(params.get("other").toString());
        Map<String, Object> otherMap = jsonObject;
        for (Map.Entry<String, Object> entry : otherMap.entrySet()){
            params.put(entry.getKey(), entry.getValue());
        }

        // 剩余参数补正
        params.put("deleteFlg", DishEntity.DISH_DELETE_0); // 未删除
        params.put("start", Integer.parseInt(params.get("start").toString())); //格式转换
        params.put("rows", Integer.parseInt(params.get("rows").toString())); //格式转换

        // 从数据库中获取相应数据
        List<DishEntity> dishEntityList = dishService.SelectAllDish(params);

        String jsonStr = com.alibaba.fastjson.JSONObject.toJSONString(dishEntityList);

        return jsonStr;
    }
}
