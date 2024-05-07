package org.library.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Genre {
    @Id
    @GeneratedValue
    long id;
    @Column(length = 50)
    String name;
    @ManyToMany(mappedBy = "genres")
    private List<Author> authors;

    public Genre(String name) {
        this.name = name;
    }

    public Genre() {
    }
}
