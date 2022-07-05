package ru.brin.sprignbootlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.brin.sprignbootlibrary.dao.AuthorDao;
import ru.brin.sprignbootlibrary.domain.Author;
import ru.brin.sprignbootlibrary.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional
public class AuthorService implements AuthorDao {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, sortDirection));
    }

    @Override
    public List<Author> getAllWithSort(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Author get(long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found author with id = " + id));
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    @Override
    public List<Author> search(String... searchStr) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchStr[0]);
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField,
                               Sort.Direction sortDirection, String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0],
                PageRequest.of(pageNumber, pageSize, sortDirection));
    }
}
