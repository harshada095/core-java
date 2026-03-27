package com.skills.service;

import com.skills.entity.Product;

public interface ProductService {
    void add(Product p);
    void update(Product p);
    void delete(int id);
    Product search(int id);
    void display();
}