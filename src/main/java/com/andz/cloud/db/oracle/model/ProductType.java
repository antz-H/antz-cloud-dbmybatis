package com.andz.cloud.db.oracle.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_PRODUCT_TYPE")
public class ProductType {
    @Id
    @Column(name = "PRODUCT_TYPE")
    private Short productType;

    @Column(name = "TYPE_NAME")
    private String typeName;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    /**
     * @return PRODUCT_TYPE
     */
    public Short getProductType() {
        return productType;
    }

    /**
     * @param productType
     */
    public void setProductType(Short productType) {
        this.productType = productType;
    }

    /**
     * @return TYPE_NAME
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * @param typeName
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * @return CREATETIME
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return MODIFYTIME
     */
    public Date getModifytime() {
        return modifytime;
    }

    /**
     * @param modifytime
     */
    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}