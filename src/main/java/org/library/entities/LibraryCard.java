package org.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public record LibraryCard(
        @Id
        long number
) {
}
