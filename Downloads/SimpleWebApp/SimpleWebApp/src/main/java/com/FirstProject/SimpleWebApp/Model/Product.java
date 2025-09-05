package com.FirstProject.SimpleWebApp.Model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Entity
@Data // This single annotation creates all getters, setters, toString, etc.
@NoArgsConstructor // Creates the default empty constructor: new Product()
@AllArgsConstructor // Creates the constructor with all fields: new Product(id, name, price)
public class Product {
    
    @Id
    private int prodId;
    private String prodName;
    private int price;

    // With the Lombok annotations above, you do not need to write
    // any constructors, getters, or setters yourself.
    // This code is now clean, correct, and much easier to read.
}
