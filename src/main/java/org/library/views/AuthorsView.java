package org.library.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "authors", layout = MainView.class)
@PageTitle("Authors")
public class AuthorsView extends VerticalLayout {
    public AuthorsView() {
        add(new H1("Author View"));
    }
}
