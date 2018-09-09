package com.andz.cloud.db.oracle.model;

import lombok.Data;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Data
@Table(name = "T_PRODUCT_REGION")
public class ProductRegion {
    @Column(name = "REGION_ID")
    private Short regionId;

    @Column(name = "REGION_NAME")
    private String regionName;

    @Column(name = "CREATETIME")
    private Date createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    List<Product> products ;

}