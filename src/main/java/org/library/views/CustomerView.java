package org.library.views;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "customers", layout = MainView.class)
public class CustomerView extends VerticalLayout {
    public CustomerView(){
        add(new H1("Customer View"));
    }
}
