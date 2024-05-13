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
    @Column(length = 1000)
    private String description;

    public Book() {
    }

    public Book(String title, Author author, LocalDate releaseDate, Genre genre, String description) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", releaseDate=" + releaseDate +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                '}';
    }
}
