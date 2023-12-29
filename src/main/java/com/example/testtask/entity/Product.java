package com.example.testtask.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entry_date", nullable = false)
    private Date entryDate;
    @Column(name = "item_code", nullable = false, unique = true)
    private Integer itemCode;
    @Column(name = "item_name", nullable = false)
    private String itemName;
    @Column(name = "item_quantity", nullable = false)
    private Integer itemQuantity;
    @Column(name = "status", nullable = false)
    private String status;
}
