package com.FirstProject.SimpleWebApp.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FirstProject.SimpleWebApp.Model.Product;
import com.FirstProject.SimpleWebApp.Repository.ProductRepo;

@Service
public class ProductService {

    @Autowired
    ProductRepo repo;

    // List to hold our products
    // private final List<Product> products = new ArrayList<>();

    // public ProductService() {
    //     // CORRECT SYNTAX: Just pass the values in the correct order
    //     products.add(new Product(101, "Laptop", 75000));
    //     products.add(new Product(102, "Mouse", 1200));
    //     products.add(new Product(103, "Keyboard", 2500));
    // }

    // Method to get all products
    public List<Product> getProducts() {
        return repo.findAll();
    }

    // --- THIS IS THE FULLY CORRECTED METHOD ---
    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
