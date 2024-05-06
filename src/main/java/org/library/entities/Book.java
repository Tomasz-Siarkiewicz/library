package org.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public record Book(
        @Id
        @GeneratedValue
        long id,
        String title,
        Author author,
        LocalDate releaseDate,
        Genre genre,
        String description
) {
}
