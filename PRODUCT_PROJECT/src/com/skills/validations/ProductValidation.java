package com.skills.validations;

import com.skills.entity.Product;
import com.skills.exceptions.InvalidDataException;

public class ProductValidation {
    public static void validate(Product p) throws InvalidDataException {
        if (p.getId() <= 0)
            throw new InvalidDataException("Invalid ID");
        if (p.getName().isEmpty())
            throw new InvalidDataException("Name required");
    }
}