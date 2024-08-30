package com.example.msvc_stock.infrastructure.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer stock;
    private Double price;
    @ManyToMany
    private Set<CategoryEntity> categories;
    @ManyToOne
    private BrandEntity brand;

    public ProductEntity() {
    }
}
