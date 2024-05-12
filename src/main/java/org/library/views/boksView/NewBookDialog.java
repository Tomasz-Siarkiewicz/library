package org.library.views.boksView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.library.entities.Author;
import org.library.entities.Genre;
import org.library.services.AuthorService;
import org.library.services.GenreService;

public class NewBookDialog extends Dialog {
    private final AuthorService authorService;
    private final GenreService genreService;
    private FormLayout form;
    TextField title = new TextField("Tytuł");
    DatePicker releaseDate = new DatePicker("Data wydania");
    TextField description = new TextField("Opis");
    ComboBox<Author> author;
    ComboBox<Genre> genre;

    Button save = new Button("Zapisz");
    Button close = new Button("Anuluj");


    public NewBookDialog(AuthorService authorService, GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
        author = createAuthorComboBox(authorService);
        genre = createGenreComboBox(genreService);
        form = createForm();
        this.setHeaderTitle("Dodaj Książkę");
        this.add(form);

        this.add(createButtonLayout());
    }

    private HorizontalLayout createButtonLayout() {
        save.addClickListener(event -> validateAndSave());
        close.addClickListener(event -> this.close());
        return new HorizontalLayout(save, close);
    }

    private void validateAndSave() {

    }

    private FormLayout createForm() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(
                title,
                author,
                releaseDate,
                genre,
                description);
        return formLayout;
    }

    private ComboBox<Genre> createGenreComboBox(GenreService genreService) {
        ComboBox<Genre> box = new ComboBox<>("Genre");
        box.setItems(genreService.findAll());
        box.setItemLabelGenerator(Genre::getName);
        return box;
    }

    private ComboBox<Author> createAuthorComboBox(AuthorService authorService) {
        ComboBox<Author> box = new ComboBox<>("Autor");
        box.setItems(authorService.findAll());
        box.setItemLabelGenerator(Author::getName);
        return box;
    }

}
