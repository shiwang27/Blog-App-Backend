package com.FirstProject.SimpleWebApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FirstProject.SimpleWebApp.Model.Product;
import com.FirstProject.SimpleWebApp.Service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    // This handles GET requests for all products
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    // This handles GET requests for a single product by ID
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId) {
        return service.getProductById(prodId);
    }

    // --- NEW METHOD TO HANDLE POST REQUESTS ---
    // This method will be called when you send a POST request to /products
    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        // The @RequestBody annotation tells Spring Boot to take the JSON from
        // the request body and convert it into a Product object.
        service.addProduct(product);
    }

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        service.deleteProduct(prodId);
    }
}
