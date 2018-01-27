package com.school.entity;

import java.io.Serializable;

/**
 * CartEntity table: tbl_cart
 *
 * @author
 */
public class CartEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** tcId  */
    private Long tcId;

    /** tcNum  */
    private String tcNum;

    /** tdId  */
    private Long tdId;

    /** tuId  */
    private Long tuId;


    /**
     * @return the tcId
     */
    public Long getTcId() {
        return this.tcId;
    }

    /**
     * @param tcId the tcId to set
     */
    public void setTcId(Long tcId) {
        this.tcId = tcId;
    }

    /**
     * @return the tcNum
     */
    public String getTcNum() {
        return this.tcNum;
    }

    /**
     * @param tcNum the tdName to set
     */
    public void setTcNum(String tcNum) {
        this.tcNum = tcNum;
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
     * 覆盖父类toString方法
     */
    @Override
    public String toString() {
        return "CartEntity ["
                +"tcId:"+tcId
                +",tcNum:"+tcNum
                +",tdId:"+tdId
                +",tcId:"+tuId
                +"]";
    }
}
