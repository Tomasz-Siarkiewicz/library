package org.library.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long id;
    @Column(length = 50)
    private String firstname;
    @Column(length = 50)
    private String lastName;
    private LocalDate registerDate;
    @OneToOne
    @JoinColumn(name = "card_id")
    private LibraryCard libraryCard;
    @Column(length = 50)
    private String idDocumentNumber;

    public Customer(String firstname, String lastName, String idDocumentNumber, LibraryCard libraryCard) {
        this.firstname = firstname;
        this.lastName = lastName;
        this.idDocumentNumber = idDocumentNumber;
        this.registerDate = LocalDate.now();
        this.libraryCard = libraryCard;
    }

    public Customer() {

    }
}
