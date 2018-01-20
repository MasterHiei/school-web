/*
 * Copyright (C), 2016-2017 
 * FileName: TblDishEntity.java
 * auto create by wangguhua
 * Author:   
 * Date:     2017-11-22 18:10:55
 * Description: TblDishEntity实体类   
 */
 
package com.school.entity;

import java.io.Serializable;



import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * 实体类DishEntity table: tbl_dish
 * 
 * @author
 */
public class DishEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;
    /** DISH_DELETE_0 */
    public static final String DISH_DELETE_0 = "0";
    /** DISH_DELETE_1 */
    public static final String DISH_DELETE_1 = "1";
    
    /** tdId  */
    private Long tdId;
    
    /** tdName  */
    private String tdName;
    
    /** tdImg  */
    private String tdImg;
    
    /** tuId  */
    private Long tuId;
    
    /** tdPrice  */
    private String tdPrice;
    
    /** tdDate  */
    private Timestamp tdDate;
    
    /** tdDetail  */
    private String tdDetail;
    
    /** deleteFlg  */
    private String deleteFlg;

    /** teName **/
    private String teName;

    /**
     * @return the tdId
     */
    public Long getTdId() {
        return this.tdId;
    }

    /**
     * @param tdId the tdId to set
     */
    public void setTdId(Long tdId) {
        this.tdId = tdId;
    }
    
    /**
     * @return the tdName
     */
    public String getTdName() {
        return this.tdName;
    }

    /**
     * @param tdName the tdName to set
     */
    public void setTdName(String tdName) {
        this.tdName = tdName;
    }
    
    /**
     * @return the tdImg
     */
    public String getTdImg() {
        return this.tdImg;
    }

    /**
     * @param tdImg the tdImg to set
     */
    public void setTdImg(String tdImg) {
        this.tdImg = tdImg;
    }
    
    /**
     * @return the tuId
     */
    public Long getTuId() {
        return this.tuId;
    }

    /**
     * @param tuId the tuId to set
     */
    public void setTuId(Long tuId) {
        this.tuId = tuId;
    }
    
    /**
     * @return the tdPrice
     */
    public String getTdPrice() {
        return this.tdPrice;
    }

    /**
     * @param tdPrice the tdPrice to set
     */
    public void setTdPrice(String tdPrice) {
        this.tdPrice = tdPrice;
    }
    
    /**
     * @return the tdDate
     */
    public Timestamp getTdDate() {
        return this.tdDate;
    }

    /**
     * @param tdDate the tdDate to set
     */
    public void setTdDate(Timestamp tdDate) {
        this.tdDate = tdDate;
    }
    
    /**
     * @return the tdDetail
     */
    public String getTdDetail() {
        return this.tdDetail;
    }

    /**
     * @param tdDetail the tdDetail to set
     */
    public void setTdDetail(String tdDetail) {
        this.tdDetail = tdDetail;
    }
    
    /**
     * @return the deleteFlg
     */
    public String getDeleteFlg() {
        return this.deleteFlg;
    }

    /**
     * @param deleteFlg the deleteFlg to set
     */
    public void setDeleteFlg(String deleteFlg) {
        this.deleteFlg = deleteFlg;
    }

    /**
     * @return the teName
     */
    public String getTeName() {
        return this.teName;
    }

    /**
     * @param teName the deleteFlg to set
     */
    public void setTeName(String teName) {
        this.teName = teName;
    }
    
	/**
     * 覆盖父类toString方法
     */    
    @Override
    public String toString() {
        return "DishEntity ["
        	+"tdId:"+tdId
        	+",tdName:"+tdName
        	+",tdImg:"+tdImg
        	+",tcId:"+tuId
        	+",tdPrice:"+tdPrice
        	+",tdDate:"+tdDate
        	+",tdDetail:"+tdDetail
        	+",deleteFlg:"+deleteFlg
            +",teName:"+teName
        +"]";
    }
}