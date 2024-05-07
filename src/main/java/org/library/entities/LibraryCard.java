package org.library.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
public class LibraryCard{

        @Id
        @GeneratedValue
        private long id;
        private String number;

        public LibraryCard(String number) {
                this.number = number;
        }

        public LibraryCard() {

        }
}
