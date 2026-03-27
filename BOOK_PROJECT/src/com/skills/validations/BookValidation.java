package com.skills.validations;

import com.skills.entity.Book;
import com.skills.exceptions.InvalidDataException;

public class BookValidation {
    public static void validate(Book b) throws InvalidDataException {
        if (b.getId() <= 0)
            throw new InvalidDataException("Invalid ID");
        if (b.getName().isEmpty())
            throw new InvalidDataException("Name required");
    }
}