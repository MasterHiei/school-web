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
    private int tcNum;

    /** tdId  */
    private Long tdId;

    /** tuId  */
    private Long tuId;

    /** tdName  */
    private String tdName;

    /** tdImg  */
    private String tdImg;

    /** tdPrice  */
    private String tdPrice;

    /** tdStock  */
    private String tdStock;

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
    public int getTcNum() {
        return this.tcNum;
    }

    /**
     * @param tcNum the tcNum to set
     */
    public void setTcNum(int tcNum) {
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
     * @return the tdName
     */
    public String getTdName() {
        return tdName;
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
        return tdImg;
    }

    /**
     * @param tdImg the tdImg to set
     */
    public void setTdImg(String tdImg) {
        this.tdImg = tdImg;
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
     * @return the tdStock
     */
    public String getTdStock() {
        return tdStock;
    }

    /**
     * @param tdStock the tdStock to set
     */
    public void setTdStock(String tdStock) {
        this.tdStock = tdStock;
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
                +",tdName:"+tdName
                +",tdImg:"+tdImg
                +",tdPrice:"+tdPrice
                +",tdStock:"+tdStock
                +"]";
    }
}
