package org.library.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.FetchProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public final class Author{
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Genre> genres;

    public Author(String name, List<Genre> genres) {
        this.name = name;
        this.genres = genres;
    }

    public Author() {
    }

    public Author(String name, Set<Genre> genres) {
        this.name = name;
        this.genres = new ArrayList<>(genres);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public List<Genre> getGenres() {
        return genres;
    }

}
