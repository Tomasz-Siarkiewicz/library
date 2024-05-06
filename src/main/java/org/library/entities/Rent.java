package org.library.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public record Rent(
        @Id
        @GeneratedValue
        long id,
        LocalDateTime startDate,
        LocalDateTime endDate,
        @ManyToOne
        @JoinColumn(name ="customer_id")
        Customer customer
) {
}
