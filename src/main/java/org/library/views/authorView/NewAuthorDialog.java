package org.library.views.authorView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.library.entities.Author;
import org.library.entities.Genre;
import org.library.services.AuthorService;
import org.library.services.GenreService;

public class NewAuthorDialog extends Dialog {
    private final AuthorService authorService;
    private final GenreService genreService;
    private FormLayout form;
    private TextField authorName;
    private MultiSelectComboBox<Genre> genres;
    private Button save = new Button("Zapisz");
    private Button close = new Button("Anuluj");

    public NewAuthorDialog(AuthorService authorService, GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
        authorName = new TextField("Imię i Nazwisko");
        genres = configureGenresComboBox();
        form = configureForm();
        this.add(form);
        this.add(createButtonLayout());

    }

    private HorizontalLayout createButtonLayout() {
        save.addClickListener(event -> save());
        close.addClickListener(event -> this.close());
        return new HorizontalLayout(save, close);
    }

    private void save() {
        if (valid()) {
            Author author = new Author(authorName.getValue(), genres.getValue());
            authorService.save(author);
            clearForm();
            this.close();
            getUI().get().getPage().reload();
        }
    }

    private void clearForm() {
        authorName.setValue(authorName.getEmptyValue());
        genres.setItems(genres.getEmptyValue());
    }

    private boolean valid() {
        return (!authorName.isEmpty() && authorName.getValue() != null) &&
                (!genres.isEmpty() && genres.getValue() != null);
    }

    private FormLayout configureForm() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(
                authorName,
                genres
        );
        return formLayout;
    }

    private MultiSelectComboBox configureGenresComboBox() {
        MultiSelectComboBox<Genre> box = new MultiSelectComboBox<>("Genre");
        box.setItems(genreService.findAll());
        box.setItemLabelGenerator(Genre::getName);
        return box;
    }
}
