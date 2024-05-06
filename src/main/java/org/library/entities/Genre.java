package org.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public record Genre(
        @Id
        @GeneratedValue
        long id,
        String name
) {
}
