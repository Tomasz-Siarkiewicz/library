package org.library.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
import java.util.Objects;

@Entity
public final class Author {
    @Id
    @GeneratedValue
    private  long id;
    private  String name;
    @ElementCollection
    private  List<Genre> genres;

}
