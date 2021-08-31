package com.edu.zhl.controller;

import com.edu.zhl.service.BookDao;
import com.edu.zhl.service.impl.BookDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class BookController {

    private BookDao bookDao;

    @Autowired
    public BookController(BookDao bookDao){
        this.bookDao = bookDao;
    }
    public BookController(){}
    public void getName(){
        bookDao.getName();
    }

    public static void main(String[] args) {
        BookController bookController = new BookController(new BookDaoImpl());
        bookController.getName();
    }
}
