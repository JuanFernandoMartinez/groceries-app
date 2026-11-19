package com.escomart.home.groceries_app.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "product_list_item")
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class ProductListItem {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int total;

    @ManyToOne  
    private Product product;

    private double realPrice;

    private int realTotal;
}
