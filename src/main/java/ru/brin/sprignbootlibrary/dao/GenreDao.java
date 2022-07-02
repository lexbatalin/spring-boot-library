package ru.brin.sprignbootlibrary.dao;

import ru.brin.sprignbootlibrary.dao.common.CrudDao;
import ru.brin.sprignbootlibrary.dao.common.SearchDao;
import ru.brin.sprignbootlibrary.domain.Genre;

public interface GenreDao extends CrudDao<Genre>, SearchDao<Genre> {
}
