package ru.brin.sprignbootlibrary.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.brin.sprignbootlibrary.dao.common.CrudDao;
import ru.brin.sprignbootlibrary.dao.common.SearchDao;
import ru.brin.sprignbootlibrary.domain.Book;

import java.util.List;

public interface BookDao extends CrudDao<Book>, SearchDao<Book> {

    List<Book> findTopBooks(Integer limit);

    byte[] getContentById(long id);

    Page<Book> getBookByGenre(int pageNumber, int pageSize, Sort.Direction sortDirection, long genreId);
}
