package com.escomart.home.groceries_app.entities;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Stock {

    @Id 
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String summary;

    @OneToMany 
    private List<ProductStock> products;

}
