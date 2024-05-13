package org.library.views.boksView;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.library.entities.Book;
import org.library.services.BookService;

public class BookDeleteDialog extends Dialog {
    private final BookService bookService;
    private Book selectedBook;
    private Button confirmDelete = new Button("Usuń");
    private Button cancelDelete = new Button("Anuluj");

    public BookDeleteDialog(BookService bookService, Book selectedBook) {
        this.selectedBook = selectedBook;
        this.bookService = bookService;
        this.add(createButtonLayout());
    }

    private HorizontalLayout createButtonLayout() {
        confirmDelete.addClickListener(event -> handleDelete());
        cancelDelete.addClickListener(event -> this.close());
        return new HorizontalLayout(cancelDelete, confirmDelete);
    }

    private void handleDelete() {
        bookService.delete(selectedBook);
        this.close();
        getUI().get().getPage().reload();
    }
}
