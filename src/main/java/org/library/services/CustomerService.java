package org.library.services;

import org.library.entities.Customer;
import org.library.entities.LibraryCard;
import org.library.repositories.CustomerRepository;
import org.library.repositories.LibraryCardRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final LibraryCardRepository libraryCardRepository;
    private final CustomerRepository customerRepository;

    public CustomerService(LibraryCardRepository libraryCardRepository, CustomerRepository customerRepository) {
        this.libraryCardRepository = libraryCardRepository;
        this.customerRepository = customerRepository;
    }
    public Customer saveCustomer(String firstName, String lastName, String documentNum){
        LibraryCard card = libraryCardRepository.save(Util.generateLibraryCard(libraryCardRepository));

        return customerRepository.save(new Customer(firstName, lastName,documentNum, card));
    }
}
