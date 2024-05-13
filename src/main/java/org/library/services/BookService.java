package org.library.services;

import org.library.SortOptions;
import org.library.entities.Book;
import org.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public void save(Book book) {
        bookRepository.save(book);
    }

    public void delete(Book book) {

        bookRepository.delete(book);
    }

    public List<Book> findFilteredAndSorted(String filterBy, SortOptions sortBy) {
        List<Book> books = new ArrayList<>();
        switch (sortBy) {
            case TITLE_ASC -> books = bookRepository.findAllByTitleContainingIgnoreCaseOrderByTitleAsc(filterBy);
            case TITLE_DESC -> books = bookRepository.findAllByTitleContainingIgnoreCaseOrderByTitleDesc(filterBy);
            case RELEASE_ASC -> books = bookRepository.findAllByTitleContainingIgnoreCaseOrderByReleaseDate(filterBy);
            case RELEASE_DESC -> books = bookRepository.findAllByTitleContainingIgnoreCaseOrderByReleaseDateDesc(filterBy);
        }
        return books;
    }
}
