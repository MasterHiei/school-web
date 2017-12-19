package com.school.entity;

import java.io.Serializable;

/**
 * ExhibitionEntity table: tbl_exhibition
 *
 * @author
 */
public class ExhibitionEntity implements Serializable {
    /** Serial UID */
    private static final long serialVersionUID = 1L;

    /** teId  */
    private Long teId;

    /** teName  */
    private String teName;

    /** tuId  */
    private Long tuId;

    /** deleteFlg  */
    private String deleteFlg;


    /**
     * @return the teId
     */
    public Long getTeId() {
        return this.teId;
    }

    /**
     * @param teId the teId to set
     */
    public void setTeId(Long teId) {
        this.teId = teId;
    }

    /**
     * @return the teName
     */
    public String getTeName() {
        return this.teName;
    }

    /**
     * @param teName the tdName to set
     */
    public void setTeName(String teName) {
        this.teName = teName;
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
        return "ExhibitionEntity ["
                +"teId:"+teId
                +",teName:"+teName
                +",tcId:"+tuId
                +",deleteFlg:"+deleteFlg
                +"]";
    }
}
