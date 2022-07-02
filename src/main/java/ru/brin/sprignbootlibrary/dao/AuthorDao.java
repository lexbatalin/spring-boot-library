package ru.brin.sprignbootlibrary.dao;

import ru.brin.sprignbootlibrary.dao.common.CrudDao;
import ru.brin.sprignbootlibrary.dao.common.SearchDao;
import ru.brin.sprignbootlibrary.domain.Author;

public interface AuthorDao extends CrudDao<Author>, SearchDao<Author> {
}
