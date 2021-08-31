package com.edu.zhl.service.impl;

import com.edu.zhl.service.BookDao;
import org.springframework.stereotype.Service;

@Service
public class BookDaoImpl implements BookDao {
    @Override
    public void getName() {
        System.out.println("bookdaoimpl");
    }
}
