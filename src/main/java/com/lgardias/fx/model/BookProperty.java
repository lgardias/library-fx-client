package com.lgardias.fx.model;

import javafx.beans.property.SimpleStringProperty;


public class BookProperty {

    private SimpleStringProperty title;
    private SimpleStringProperty author;
    private SimpleStringProperty borrowed;

    public BookProperty(Book book){
        this.title = new SimpleStringProperty(book.getTitle());
        this.author = new SimpleStringProperty(book.getAuthor());
        this.borrowed = new SimpleStringProperty(book.getBorrowed());
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getBorrowed() {
        return borrowed.get();
    }

    public SimpleStringProperty borrowedProperty() {
        return borrowed;
    }

    public void setBorrowed(String borrowed) {
        this.borrowed.set(borrowed);
    }

}
