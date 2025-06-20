package com.example.ecommerce_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "inventory")
public class Inventory {

    /** Unique id for the inventory. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /** The product this inventory is of. */
    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;

    /** The quantity in stock. */
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
