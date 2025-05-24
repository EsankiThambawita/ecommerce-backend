package com.example.ecommerce_backend;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TestDataObject {

    @Id
    private long Id;
    @Column
    private String username;
}
