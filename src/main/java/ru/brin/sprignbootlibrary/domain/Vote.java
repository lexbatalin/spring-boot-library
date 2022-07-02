package ru.brin.sprignbootlibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "vote")
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Long count;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "user_name")
    private String userName;
}
