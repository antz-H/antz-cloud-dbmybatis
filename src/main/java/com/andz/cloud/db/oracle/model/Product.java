package com.andz.cloud.db.oracle.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import javax.persistence.*;

@ToString
@Table(name = "T_PRODUCT")
@Data
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "PRODUCT_NO")
    private Long productNo;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_TYPE")
    private Long productType;

    @Column(name = "CREATETIME")
    private String createtime;

    @Column(name = "MODIFYTIME")
    private Date modifytime;

    @Column(name = "REGION")
    private Long region;

    private ProductRegion productRegion ;
}