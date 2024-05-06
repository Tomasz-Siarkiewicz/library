package org.library.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "rent", layout = MainView.class)
@PageTitle("Rent")
public class RentView extends VerticalLayout {
    public RentView() {
        add(new H1("Rent view"));
    }
}
