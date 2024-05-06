package org.library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private LocalDate releaseDate;
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    private String description;
}
