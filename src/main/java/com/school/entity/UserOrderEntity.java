package com.school.entity;

import java.io.Serializable;

/**
 * UserOrderEntity table: tbl_user_order
 *
 * @author
 */
public class UserOrderEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** tuoId  */
    private Long tuoId;

    /** tuId  */
    private Long tuId;

    /** toId  */
    private Long toId;

    /** tuoDetail  */
    private String tuoDetail;

    /**
     * @return the tuoId
     */
    public Long getTuoId() {
        return this.tuoId;
    }

    /**
     * @param tuoId the tuoId to set
     */
    public void setTuoId(Long tuoId) {
        this.tuoId = tuoId;
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
     * @return the tuoDetail
     */
    public String getTuoDetail() {
        return this.tuoDetail;
    }

    /**
     * @param tuoDetail the tuoDetail to set
     */
    public void setTuoDetail(String tuoDetail) {
        this.tuoDetail = tuoDetail;
    }

    /**
     * 覆盖父类toString方法
     */
    @Override
    public String toString() {
        return "UserEntity ["
                +"tcId:"+tuoId
                +",tcName:"+tuId
                +",tcPwd:"+toId
                +",tcAddress:"+tuoDetail
                +"]";
    }


}
