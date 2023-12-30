package com.example.testtask.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entry_date", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date entryDate;
    @Column(name = "item_code", nullable = false)
    private Integer itemCode;
    @Column(name = "item_name", nullable = false)
    private String itemName;
    @Column(name = "item_quantity", nullable = false)
    private Integer itemQuantity;
    @Column(name = "status", nullable = false)
    private String status;
}
