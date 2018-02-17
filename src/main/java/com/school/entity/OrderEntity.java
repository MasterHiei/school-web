/*
 * Copyright (C), 2016-2017 
 * FileName: TblOrderEntity.java
 * auto create by wangguhua
 * Author:   
 * Date:     2017-11-22 18:10:55
 * Description: TblOrderEntity实体类   
 */
 
package com.school.entity;

import java.io.Serializable;



import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * 实体类OrderEntity table: tbl_order
 * 
 * @author
 */
public class OrderEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;
    /** ORDER_DELETE_FLG_0 */
    public static final String ORDER_DELETE_FLG_0 = "0";
    /** ORDER_DELETE_FLG_1 */
    public static final String ORDER_DELETE_FLG_1 = "1";
    /** ORDER_STATUS_FLG_0（未受理） */
    public static final String ORDER_STATUS_FLG_0 = "0";
    /** ORDER_STATUS_FLG_1（已受理） */
    public static final String ORDER_STATUS_FLG_1 = "1";
    /** ORDER_STATUS_FLG_2（已完成） */
    public static final String ORDER_STATUS_FLG_2 = "2";
    
    /** toId  */
    private Long toId;
    
    /** toNum  */
    private int toNum;
    
    /** toPrice  */
    private String toPrice;

    /** tdName  */
    private String tdName;

    /** toDate  */
    private Date toDate;

    /** tuId  */
    private Long tuId;
    
    /** statusFlg 0：未受理 1：已受理 2：已完成 */
    private String statusFlg;
    
    /** deleteFlg  */
    private String deleteFlg;
    

    /**
     * @return the toId
     */
    public Long getToId() {
        return this.toId;
    }

    /**
     * @param toId the toId to set
     */
    public void setToId(Long toId) {
        this.toId = toId;
    }
    
    /**
     * @return the toNum
     */
    public int getToNum() {
        return this.toNum;
    }

    /**
     * @param toNum the toNum to set
     */
    public void setToNum(int toNum) {
        this.toNum = toNum;
    }
    
    /**
     * @return the toPrice
     */
    public String getToPrice() {
        return this.toPrice;
    }

    /**
     * @param toPrice the toPrice to set
     */
    public void setToPrice(String toPrice) {
        this.toPrice = toPrice;
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
     * @return the toDate
     */
    public Date getToDate() {
        return this.toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
    
    /**
     * @return the statusFlg
     */
    public String getStatusFlg() {
        return this.statusFlg;
    }

    /**
     * @param statusFlg the statusFlg to set
     */
    public void setStatusFlg(String statusFlg) {
        this.statusFlg = statusFlg;
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
     * 覆盖父类toString方法
     */    
    @Override
    public String toString() {
        return "OrderEntity ["
        	+"toId:"+toId
        	+",toNum:"+toNum
        	+",toPrice:"+toPrice
            +",toDate:"+toDate
        	+",tdName:"+tdName
            +",tuId:"+tuId
        	+",statusFlg:"+statusFlg
        	+",deleteFlg:"+deleteFlg
        +"]";
    }
}