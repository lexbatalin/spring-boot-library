package ru.brin.sprignbootlibrary.dao;

import ru.brin.sprignbootlibrary.dao.common.CrudDao;
import ru.brin.sprignbootlibrary.dao.common.SearchDao;
import ru.brin.sprignbootlibrary.domain.Publisher;

public interface PublisherDao extends CrudDao<Publisher>, SearchDao<Publisher> {
}
