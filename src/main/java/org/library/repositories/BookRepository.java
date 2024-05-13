package org.library.repositories;

import org.library.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitleContainingIgnoreCaseOrderByTitleAsc(String filterBy);

    List<Book> findAllByTitleContainingIgnoreCaseOrderByTitleDesc(String filterBy);

    List<Book> findAllByTitleContainingIgnoreCaseOrderByReleaseDate(String filterBy);

    List<Book> findAllByTitleContainingIgnoreCaseOrderByReleaseDateDesc(String filterBy);
}
