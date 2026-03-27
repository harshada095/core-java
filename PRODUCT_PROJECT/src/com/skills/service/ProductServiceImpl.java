package com.skills.service;

import java.util.*;
import com.skills.entity.Product;
import com.skills.validations.ProductValidation;
import com.skills.exceptions.InvalidDataException;

public class ProductServiceImpl implements ProductService {

    List<Product> list = new LinkedList<>();

    public void add(Product p) {
        try {
            ProductValidation.validate(p);
            list.add(p);
            System.out.println("Added");
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Product p) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == p.getId()) {
                list.set(i, p);
            }
        }
    }

    public void delete(int id) {
        list.removeIf(p -> p.getId() == id);
    }

    public Product search(int id) {
        return list.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void display() {
        list.forEach(System.out::println);
    }
}