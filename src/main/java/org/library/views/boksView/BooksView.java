package org.library.views.boksView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import org.library.entities.Book;
import org.library.services.AuthorService;
import org.library.services.BookService;
import org.library.services.GenreService;
import org.library.views.MainView;

import java.util.List;

@Route(value = "Books", layout = MainView.class)
@PageTitle("Books")
public class BooksView extends VerticalLayout {
    private final BookService bookService;
    private Grid<Book> bookGrid;
    private BooksInfoComponent bookInfo;
    private NewBookDialog newBookDialog;


    public BooksView(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        newBookDialog = new NewBookDialog(authorService, genreService, bookService);
        configureGrid();
        add(bookGrid);
        add(new Button("Dodaj książkę", e -> newBookDialog.open()));
        add(bookInfo);
        add(newBookDialog);
    }

    private void configureGrid() {
        bookGrid = new Grid<>(Book.class, false);
        bookGrid.addColumn(Book::getTitle).setHeader("Tytuł");
        bookGrid.addColumn(book -> book.getAuthor().getName()).setHeader("Autor");
        bookGrid.addColumn(Book::getReleaseDate).setHeader("Data Wydania");
        List<Book> all = bookService.findAll();
        bookGrid.setItems(all);
        bookGrid.asSingleSelect().addValueChangeListener(e -> {
                    bookInfo.setSelected(e.getValue());
                }
        );
        createBookInfo(all.get(0));
    }

    private void createBookInfo(Book book) {
        bookInfo = new BooksInfoComponent(book, bookService);
    }
}
