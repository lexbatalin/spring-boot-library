package ru.brin.sprignbootlibrary.dao.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface SearchDao<T> {
    List<T> search(String... searchStr);
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);
}
