package org.library.views.boksView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.library.entities.Book;
import org.library.services.BookService;

public class BooksInfoComponent extends VerticalLayout {
    private final BookService bookService;
    private Book selected;
    private Button deleteButton;
    private Dialog confirmDeleteDialog;

    public BooksInfoComponent(Book book, BookService bookService) {
        this.selected = book;
        this.bookService = bookService;
        deleteButton = new Button("Usuń");
        deleteButton.addClickListener(event -> delete());
        add(new H1(this.selected.getTitle()));
        add(new H2(this.selected.getAuthor().getName()));
        add(new H3(this.selected.getDescription()));
        add(deleteButton);
    }

    public void setSelected(Book book) {
        selected = book;
        removeAll();
        if (book != null) {
            add(new H1(this.selected.getTitle()));
            add(new H2(this.selected.getAuthor().getName()));
            add(new H3(this.selected.getDescription()));
            add(deleteButton);
        }
    }

    private void delete() {
        confirmDeleteDialog = new BookDeleteDialog(bookService, selected);
        this.add(confirmDeleteDialog);
        confirmDeleteDialog.open();
    }

}
