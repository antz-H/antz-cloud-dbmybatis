package com.andz.cloud.db.oracle.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "T_USER")
@Data
public class User {
    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    private Integer sex;
}