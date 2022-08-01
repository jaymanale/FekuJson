package com.springboot.app.fekuAPI.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "product")
public class Product implements Comparable<Product>{

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "material")
    private String material;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "department")
    private String department;

    @Column(name = "color")
    private String color;

    @Column(name = "promotion_code")
    private String promotionCode;

    public Product() {
    }

    public Product(Long id, String productName, String material, String price, String department, String color, String promotionCode) {
        this.id = id;
        this.productName = productName;
        this.material = material;
        this.price = price;
        this.department = department;
        this.color = color;
        this.promotionCode = promotionCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product product = (Product) o;
        return id != null && Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public int compareTo(Product o) {
        return this.getId().compareTo(o.getId());
    }
}
