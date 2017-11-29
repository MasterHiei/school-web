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
    
    /** toId  */
    private Long toId;
    
    /** tsId  */
    private Long tsId;
    
    /** tdId  */
    private Long tdId;
    
    /** toNo  */
    private String toNo;
    
    /** toPrice  */
    private String toPrice;
    
    /** toDate  */
    private Timestamp toDate;
    
    /** toDetail  */
    private String toDetail;
    
    /** statusFlg 0：未完成 1：已完成 */
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
     * @return the tsId
     */
    public Long getTsId() {
        return this.tsId;
    }

    /**
     * @param tsId the tsId to set
     */
    public void setTsId(Long tsId) {
        this.tsId = tsId;
    }
    
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
     * @return the toNo
     */
    public String getToNo() {
        return this.toNo;
    }

    /**
     * @param toNo the toNo to set
     */
    public void setToNo(String toNo) {
        this.toNo = toNo;
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
     * @return the toDate
     */
    public Timestamp getToDate() {
        return this.toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }
    
    /**
     * @return the toDetail
     */
    public String getToDetail() {
        return this.toDetail;
    }

    /**
     * @param toDetail the toDetail to set
     */
    public void setToDetail(String toDetail) {
        this.toDetail = toDetail;
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
        	+",tsId:"+tsId
        	+",tdId:"+tdId
        	+",toNo:"+toNo
        	+",toPrice:"+toPrice
        	+",toDate:"+toDate
        	+",toDetail:"+toDetail
        	+",statusFlg:"+statusFlg
        	+",deleteFlg:"+deleteFlg
        +"]";
    }
    

}