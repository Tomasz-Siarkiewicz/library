package org.library.views.boksView;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.library.entities.Book;

public class BooksInfoComponent extends VerticalLayout {
    private Book selected;

    public BooksInfoComponent(Book book) {
        this.selected = book;
        add(new H1(this.selected.getTitle()));
        add(new H2(this.selected.getAuthor().getName()));
        add(new H3(this.selected.getDescription()));
    }

    public void setSelected(Book book) {
        selected = book;
        removeAll();
        add(new H1(this.selected.getTitle()));
        add(new H2(this.selected.getAuthor().getName()));
        add(new H3(this.selected.getDescription()));
    }
}
