package org.library.entities;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public record Author(
        @Id
        @GeneratedValue
        long id,
        String name,
        @ElementCollection
        List<Genre> genres
) {
}
