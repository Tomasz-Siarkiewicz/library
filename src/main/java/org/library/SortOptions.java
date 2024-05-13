package org.library;

public enum SortOptions {
    TITLE_ASC("Tytuł rosnąco"),
    TITLE_DESC("Tytuł malejąco"),
    RELEASE_ASC("Data wydania rosnąco"),
    RELEASE_DESC("Data wydania malejąco");
    String name;

    SortOptions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
