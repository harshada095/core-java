package com.skills.service;

import java.util.*;
import com.skills.entity.Book;
import com.skills.validations.BookValidation;
import com.skills.exceptions.InvalidDataException;

public class BookServiceImpl implements BookService {

    Set<Book> set = new HashSet<>();

    public void add(Book b) {
        try {
            BookValidation.validate(b);
            set.add(b);
            System.out.println("Added");
        } catch (InvalidDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        set.removeIf(b -> b.getId() == id);
    }

    public Book search(int id) {
        for (Book b : set) {
            if (b.getId() == id)
                return b;
        }
        return null;
    }

    public void display() {
        set.forEach(System.out::println);
    }

    public int count() {
        return set.size();
    }
}