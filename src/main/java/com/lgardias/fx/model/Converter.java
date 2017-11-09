package com.lgardias.fx.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lgardias.fx.controllers.GetPaneController;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class Converter {

    private static final ObjectMapper mapper = new ObjectMapper();
    private static GetPaneController getPaneController;
    public void simpleConvert(String value){


        try {
            List<Book> myObjects = mapper.readValue(value, mapper.getTypeFactory().constructCollectionType(List.class, Book.class));

            for (Book book : myObjects){
                System.out.println(book.getBorrowed());
            }
            System.out.println("sdjsdksjdhsjkfhdskfjd");
            myObjects.stream().
                    filter(book -> book.getBorrowed().equals("true")).forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static List<Book> JsonToBooks(String bookJSON, String property){

        List<Book> myBooks = new LinkedList<>();
        try {
            myBooks = mapper.readValue(bookJSON, mapper.getTypeFactory().constructCollectionType(List.class, Book.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortList(myBooks, property);
    }

    private static List<Book> sortList(List<Book> books, String property){

        List<Book> resultBooks = new LinkedList<>();
        if(property.equals(new ChoiceBoxProperties().getGProperties().get(1))){
            books.stream().filter(book -> book.getBorrowed().equals("true")).forEach(resultBooks::add);
            return resultBooks;
        }else if(property.equals(new ChoiceBoxProperties().getGProperties().get(2))){
            books.stream().filter(book -> book.getBorrowed().equals("false")).forEach(resultBooks::add);
            return resultBooks;
        }else {
            return books;
        }
    }
    public static String BookToJSON(Book book){

        String bookJSON = null;
        try {
            bookJSON = mapper.writeValueAsString(book);
            return bookJSON;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
