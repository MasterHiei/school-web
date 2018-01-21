/*
 * Copyright (C), 2016-2017 
 * FileName: TblCanteenEntity.java
 * auto create by wangguhua
 * Author:   
 * Date:     2017-11-22 18:10:55
 * Description: TblCanteenEntity实体类   
 */
 
package com.school.entity;

import java.io.Serializable;


import java.sql.Timestamp;

/**
 * 实体类UserEntity table: tbl_user
 * 
 * @author user
 */
public class UserEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;
    /** USER_SESSION(tuName) */
    public static final String USER_SESSION = "user_Session";
    /** ADMIN_PERMISSION */
    public static final long ADMIN_PERMISSION = 1001;
    /** CANTEEN_PERMISSION */
    public static final long CANTEEN_PERMISSION = 1002;
    /** STUDENT_PERMISSION */
    public static final long STUDENT_PERMISSION = 1003;
    /** USER_DELETE_0 */
    public static final String USER_DELETE_0 = "0";
    /** USER_DELETE_1 */
    public static final String USER_DELETE_1 = "1";
    
    /** tcId  */
    private Long tuId;
    
    /** tcName  */
    private String tuName;
    
    /** tcPwd  */
    private String tuPwd;
    
    /** tcAddress  */
    private String tuAddress;
    
    /** tcDate  */
    private Timestamp tuDate;
    
    /** tiId  */
    private Long tiId;
    
    /** tcDetail  */
    private String tuDetail;
    
    /** deleteFlg  */
    private String deleteFlg;
    

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
     * @return the tuName
     */
    public String getTuName() {
        return this.tuName;
    }

    /**
     * @param tuName the tuName to set
     */
    public void setTuName(String tuName) {
        this.tuName = tuName;
    }
    
    /**
     * @return the tuPwd
     */
    public String getTuPwd() {
        return this.tuPwd;
    }

    /**
     * @param tuPwd the tuPwd to set
     */
    public void setTuPwd(String tuPwd) {
        this.tuPwd = tuPwd;
    }
    
    /**
     * @return the tcAddress
     */
    public String getTuAddress() {
        return this.tuAddress;
    }

    /**
     * @param tuAddress the tuAddress to set
     */
    public void setTuAddress(String tuAddress) {
        this.tuAddress = tuAddress;
    }
    
    /**
     * @return the tuDate
     */
    public Timestamp getTuDate() {
        return this.tuDate;
    }

    /**
     * @param tuDate the tuDate to set
     */
    public void setTuDate(Timestamp tuDate) {
        this.tuDate = tuDate;
    }
    
    /**
     * @return the tiId
     */
    public Long getTiId() {
        return this.tiId;
    }

    /**
     * @param tiId the tiId to set
     */
    public void setTiId(Long tiId) {
        this.tiId = tiId;
    }
    
    /**
     * @return the tuDetail
     */
    public String getTuDetail() {
        return this.tuDetail;
    }

    /**
     * @param tuDetail the tuDetail to set
     */
    public void setTuDetail(String tuDetail) {
        this.tuDetail = tuDetail;
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
        return "UserEntity ["
        	+"tcId:"+tuId
        	+",tcName:"+tuName
        	+",tcPwd:"+tuPwd
        	+",tcAddress:"+tuAddress
        	+",tcDate:"+tuDate
        	+",tiId:"+tiId
        	+",tcDetail:"+tuDetail
        	+",deleteFlg:"+deleteFlg
        +"]";
    }
    

}