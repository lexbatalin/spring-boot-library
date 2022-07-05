package ru.brin.sprignbootlibrary.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.brin.sprignbootlibrary.dao.impl.BookService;

@Controller
@Log
public class TestController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        bookService.updateBookViewById(2L, 5L);
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
