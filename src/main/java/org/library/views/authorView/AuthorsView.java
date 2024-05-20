package org.library.views.authorView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.library.services.AuthorService;
import org.library.services.GenreService;
import org.library.views.MainView;

import java.util.List;

@Route(value = "authors", layout = MainView.class)
@PageTitle("Authors")
public class AuthorsView extends VerticalLayout {
    private final AuthorService authorService;
    private final GenreService genreService;
    private Grid<AuthorDTO> authorGrid;
    private NewAuthorDialog newAuthorDialog;

    public AuthorsView(AuthorService authorService, GenreService genreService) {
        this.authorService = authorService;
        this.genreService = genreService;
        newAuthorDialog = new NewAuthorDialog(authorService, genreService);
        configureGrid();
        add(authorGrid);
        add(newAuthorDialog);
        add(new Button("Dodaj autora", e -> newAuthorDialog.open()));
    }

    private void configureGrid() {
        authorGrid = new Grid<>(AuthorDTO.class, false);
        authorGrid.addColumn(AuthorDTO::name);
        authorGrid.addColumn(AuthorDTO::genres);
        List<AuthorDTO> authors = authorService.findAllForView();
        authorGrid.setItems(authors);
    }
}
