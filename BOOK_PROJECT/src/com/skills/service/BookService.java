package com.skills.service;

import com.skills.entity.Book;

public interface BookService {
    void add(Book b);
    void delete(int id);
    Book search(int id);
    void display();
    int count();
}