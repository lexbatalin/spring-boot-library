package ru.brin.sprignbootlibrary.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.brin.sprignbootlibrary.domain.Book;
import ru.brin.sprignbootlibrary.repository.AuthorRepository;
import ru.brin.sprignbootlibrary.repository.BookRepository;
import ru.brin.sprignbootlibrary.repository.GenreRepository;

@Controller
@Log
public class TestController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {

        Page<Book> booksGenre = bookRepository.findByGenreIdOrderByNameDesc(14, PageRequest.of(0, 5));
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}
