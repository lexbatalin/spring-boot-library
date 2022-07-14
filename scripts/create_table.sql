create table if not exists author
(
    id       bigint  not null
        constraint author_pk
            primary key,
    fio      varchar not null,
    birthday date    not null
);

create unique index if not exists author_id_uindex
    on author (id);

create table if not exists book
(
    id               bigint  not null
        constraint book_pk
            primary key,
    name             varchar not null,
    content          bytea,
    page_count       integer not null,
    isbn             varchar not null,
    genre_id         bigint  not null
        constraint book_genre_id_fk
            references genre,
    author_id        bigint  not null
        constraint book_author_id_fk
            references author,
    publish_year     integer not null,
    publisher_id     bigint  not null
        constraint book_publisher_id_fk
            references publisher,
    image            bytea,
    avg_rating       integer default 0,
    total_vote_count integer default 0,
    total_rating     integer default 0,
    view_count       bigint  default 0,
    description      varchar
);

create unique index if not exists book_id_uindex
    on book (id);

create unique index if not exists book_isbn_uindex
    on book (isbn);

create table if not exists genre
(
    id   bigint  not null
        constraint genre_pk
            primary key,
    name varchar not null
);

create unique index if not exists genre_id_uindex
    on genre (id);

create table if not exists publisher
(
    id   bigint  not null
        constraint publisher_pk
            primary key,
    name varchar not null
);

create unique index if not exists publisher_id_uindex
    on publisher (id);


create table if not exists "user"
(
);


create table if not exists user_role
(
);


create table if not exists vote
(
    id        bigint  not null,
    count     bigint default 0,
    book_id   bigint  not null,
    user_name varchar not null
        constraint vote_pk
            primary key
);

create unique index if not exists vote_id_uindex
    on vote (id);