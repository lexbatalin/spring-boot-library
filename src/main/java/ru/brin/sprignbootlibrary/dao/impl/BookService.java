package ru.brin.sprignbootlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.brin.sprignbootlibrary.dao.BookDao;
import ru.brin.sprignbootlibrary.domain.Book;
import ru.brin.sprignbootlibrary.repository.BookRepository;

import java.util.List;

@Service
@Transactional
public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findTopBooks(Integer limit) {
        return bookRepository.findTopBooks(PageRequest.of(0, limit));
    }

    @Override
    public byte[] getContentById(long id) {
        return bookRepository.getContentById(id);
    }

    @Override
    public Page<Book> getBookByGenre(int pageNumber, int pageSize, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenreIdOrderByNameDesc(genreId, PageRequest.of(pageNumber, pageSize, sortDirection));
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAll(PageRequest.of(pageNumber, pageSize, sortDirection));
    }

    @Override
    public List<Book> getAllWithSort(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Book get(long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found book with id = " + id));
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }

    @Override
    public List<Book> search(String... searchStr) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchStr[0], searchStr[1]);
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByGenreIdOrderByNameDesc(Long.parseLong(searchString[0]),
                PageRequest.of(pageNumber, pageSize, sortDirection));
    }

    @Override
    public Long updateBookViewById(long currentView, long bookId) {
        bookRepository.updateViewCount(++currentView, bookId);
        return currentView;
    }

    @Override
    public void updateRatingById(long avgRating, long totalVoteCount, long totalRating, long id) {
        bookRepository.updateRating(avgRating, totalVoteCount, totalRating, id);
    }
}
