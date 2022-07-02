package ru.brin.sprignbootlibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "book")
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Book {

    public Book() {
    }

    public Book(Long id, String name, byte[] content, Integer pageCount, String isbn, Genre genre, Author author,
                Publisher publisher, Integer publishYear, byte[] image, Integer avgRating, Integer totalVoteCount,
                Integer total_rating, Long viewCount, String descr) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.total_rating = total_rating;
        this.viewCount = viewCount;
        this.descr = descr;
    }

    public Book(Long id, String name, Integer pageCount, String isbn, Genre genre, Author author, Publisher publisher,
                Integer publishYear, byte[] image, Integer avgRating, Integer totalVoteCount, Integer total_rating,
                Long viewCount, String descr) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisher = publisher;
        this.publishYear = publishYear;
        this.image = image;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.total_rating = total_rating;
        this.viewCount = viewCount;
        this.descr = descr;
    }

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book(long id, byte[] image) {
        this.id = id;
        this.image = image;
    }

    public Book(Long id, byte[] content) {
        this.id = id;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Lob
    @Column(updatable = false)
    private byte[] content;

    @Column(name = "page_count")
    private Integer pageCount;

    private String isbn;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    @Column(name = "publish_year")
    private Integer publishYear;

    private byte[] image;

    @Column(name = "avg_rating")
    private Integer avgRating;

    @Column(name = "total_vote_count")
    private Integer totalVoteCount;

    @Column(name = "total_rating")
    private Integer total_rating;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "description")
    private String descr;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
