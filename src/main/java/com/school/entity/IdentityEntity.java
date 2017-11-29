/*
 * Copyright (C), 2016-2017 
 * FileName: TblIdentityEntity.java
 * auto create by wangguhua
 * Author:   
 * Date:     2017-11-22 18:10:55
 * Description: TblIdentityEntity实体类   
 */
 
package com.school.entity;

import java.io.Serializable;



import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.math.BigInteger;
import java.math.BigDecimal;

/**
 * 实体类IdentityEntity table: tbl_identity
 * 
 * @author
 */
public class IdentityEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;
    
    /** tiId  */
    private Long tiId;
    
    /** tiName  */
    private String tiName;
    
    /** tiDetail  */
    private String tiDetail;
    

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
     * @return the tiName
     */
    public String getTiName() {
        return this.tiName;
    }

    /**
     * @param tiName the tiName to set
     */
    public void setTiName(String tiName) {
        this.tiName = tiName;
    }
    
    /**
     * @return the tiDetail
     */
    public String getTiDetail() {
        return this.tiDetail;
    }

    /**
     * @param tiDetail the tiDetail to set
     */
    public void setTiDetail(String tiDetail) {
        this.tiDetail = tiDetail;
    }
    
	/**
     * 覆盖父类toString方法
     */    
    @Override
    public String toString() {
        return "IdentityEntity ["
        	+"tiId:"+tiId
        	+",tiName:"+tiName
        	+",tiDetail:"+tiDetail
        +"]";
    }
    

}