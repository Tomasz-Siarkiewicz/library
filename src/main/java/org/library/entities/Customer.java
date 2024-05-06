package org.library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String middleName;
    private String lastName;
    private LocalDate registerDate;
    @OneToOne
    @JoinColumn (name = "card_id")
    private LibraryCard libraryCard;
    private String idDocumentNumber;

}
