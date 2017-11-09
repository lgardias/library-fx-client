package com.lgardias.fx.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChoiceBoxProperties {

    private final String allBooksGP = "Wszyskie książki";
    private final String borrowedBooksGP = "Tylko wypożyczone";
    private final String availableBooksGP = "Tylko dostępne";

    private final String trueValuePP = "Wypożyczona";
    private final String falseValuePP = "Na stanie";

    public List<String>  getGProperties(){
        return new ArrayList<>(Arrays.asList(allBooksGP,borrowedBooksGP,availableBooksGP));
    }

    public String getTrueValuePP() {
        return trueValuePP;
    }

    public String getFalseValuePP() {
        return falseValuePP;
    }

    public String getAllBooksGP() {
        return allBooksGP;
    }
}
