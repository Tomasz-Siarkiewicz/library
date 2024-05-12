package org.library.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public final class Author {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50)
    private String name;
    @ManyToMany
    private List<Genre> genres;

    public Author(String name, List<Genre> genres) {
        this.name = name;
        this.genres = genres;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }
}
