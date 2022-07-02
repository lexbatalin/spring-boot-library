package ru.brin.sprignbootlibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "genre")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "genre")
    private List<Book> books;

    @Override
    public String toString() {
        return "Genre{" +
                "name='" + name + '\'' +
                '}';
    }
}
