package org.library.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "Books", layout = MainView.class)
@PageTitle("Books")
public class BooksView extends VerticalLayout {
    public BooksView() {
        add(new H1("Books View"));
    }
}
