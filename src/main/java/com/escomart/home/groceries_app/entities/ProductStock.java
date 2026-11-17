package com.escomart.home.groceries_app.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table 
@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
public class ProductStock {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Product product;
    private int quantity;
    private int minimumQuantity;
    private int idealQuantity;

}
