package ru.brin.sprignbootlibrary.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.brin.sprignbootlibrary.domain.Book;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(String name, String fio);

    Page<Book> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

    @Query(value = "SELECT b.content FROM book b WHERE b.id = :id", nativeQuery = true)
    byte[] getContentById(@Param("id") long id);

    Page<Book> findByGenreIdOrderByNameDesc(long genreId, Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Query(value = "update Book b set b.content=:content where b.id=:id", nativeQuery = true)
    void updateContent(@Param("content") byte[] content, @Param("id") long id);

    @Query(value = "select ru.brin.sprignbootlibrary.domain.Book(b.id, b.image) from Book b", nativeQuery = true)
    List<Book> findTopBooks(Pageable pageable);

}
