package ru.brin.sprignbootlibrary.dao.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CrudDao<T> {

    List<T> getAll();
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);
    List<T> getAllWithSort(Sort sort);
    T get(long id);
    T save(T t);
    void delete(T t);
}
