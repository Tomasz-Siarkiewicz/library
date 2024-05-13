package org.library.views.boksView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.library.SortOptions;
import org.library.entities.Book;
import org.library.services.AuthorService;
import org.library.services.BookService;
import org.library.services.GenreService;
import org.library.views.MainView;

import java.util.Arrays;
import java.util.List;

@Route(value = "Books", layout = MainView.class)
@PageTitle("Books")
public class BooksView extends VerticalLayout {
    private final BookService bookService;
    private Grid<Book> bookGrid;
    private BooksInfoComponent bookInfo;
    private NewBookDialog newBookDialog;
    private HorizontalLayout sortAndFilter;
    private TextField filterByTitle;
    private Button filter;
    private Button sort;
    private Button clear;
    private ComboBox<SortOptions> sorting;


    public BooksView(BookService bookService, AuthorService authorService, GenreService genreService) {
        this.bookService = bookService;
        newBookDialog = new NewBookDialog(authorService, genreService, bookService);
        configureGrid();
        configureSortAndFilter();
        add(sortAndFilter);
        add(bookGrid);
        add(new Button("Dodaj książkę", e -> newBookDialog.open()));
        add(bookInfo);
        add(newBookDialog);
    }

    private void configureSortAndFilter() {
        sortAndFilter = new HorizontalLayout();
        filterByTitle = new TextField();
        filterByTitle.setPlaceholder("wpisz fragment tytułu");
        filter = new Button("Wyszukaj");
        filter.addClickListener(event -> handleFilter());
        clear = new Button("Wyczyść filtrowanie");
        clear.addClickListener(event -> handleClear());
        sort = new Button("Sortuj");
        sorting = new ComboBox<>();
        sorting.setItems(Arrays.asList(SortOptions.values()));
        sorting.setValue(SortOptions.TITLE_ASC);
        sorting.setItemLabelGenerator(SortOptions::getName);

        sortAndFilter.add(filterByTitle, sorting, filter, clear);

    }

    private void handleClear() {
        bookGrid.setItems(bookService.findAll());
    }

    private void handleFilter() {
        List<Book> filteredAndSorted = bookService.findFilteredAndSorted(filterByTitle.getValue(), sorting.getValue());
        bookGrid.setItems(filteredAndSorted);
        if (filteredAndSorted.isEmpty()) {
            bookInfo.setSelected(null);
        } else {
            bookInfo.setSelected(filteredAndSorted.get(0));
        }
    }

    private void configureGrid() {
        bookGrid = new Grid<>(Book.class, false);
        bookGrid.addColumn(Book::getTitle).setHeader("Tytuł");
        bookGrid.addColumn(book -> book.getAuthor().getName()).setHeader("Autor");
        bookGrid.addColumn(Book::getReleaseDate).setHeader("Data Wydania");
        bookGrid.addColumn(book -> book.getGenre().getName()).setHeader("Gatunek");
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
