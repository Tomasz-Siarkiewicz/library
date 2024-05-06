package org.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
@Entity
public record Customer(
        @Id
        @GeneratedValue
        long id,
        String firstname,
        String middleName,
        String lastName,
        LocalDate registerDate,
        LibraryCard libraryCard,
        String idDocumentNumber
) {
}
