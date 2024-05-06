package org.library.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Rent {
    @Id
    @GeneratedValue
    private long id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
