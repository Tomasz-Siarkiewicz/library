package org.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class LibraryCard{
        @Id
        private long number;
}
