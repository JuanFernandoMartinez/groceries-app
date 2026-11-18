package com.escomart.home.groceries_app.entities;

import java.util.UUID;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "product_stock") 
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class ProductStock {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne  
    private Product product;

    private int quantity;

    @Column (name = "minimum_quantity")
    private int minimumQuantity;

    @Column (name = "ideal_quantity")
    private int idealQuantity;

}
