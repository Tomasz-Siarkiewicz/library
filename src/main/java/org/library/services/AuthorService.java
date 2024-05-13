package org.library.services;

import org.library.entities.Author;
import org.library.entities.Genre;
import org.library.repositories.AuthorRepository;
import org.library.views.authorView.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public List<AuthorDTO> findAllForView() {
        return mapToDto(findAll());
    }

    private List<AuthorDTO> mapToDto(List<Author> authors) {
        return authors.stream()
                .map(author -> new AuthorDTO(author.getId(), author.getName(),
                        author.getGenres().stream().map(Genre::getName).collect(Collectors.joining(", "))
                ))
                .collect(Collectors.toList());
    }

    public void save(Author author) {
        authorRepository.save(author);
    }
}
