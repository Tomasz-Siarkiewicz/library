package org.library.services;

import org.library.entities.Book;
import org.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
    public void delete(Book book){

        bookRepository.delete(book);
    }

}
