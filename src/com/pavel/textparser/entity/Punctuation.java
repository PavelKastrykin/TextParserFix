package com.pavel.textparser.entity;

/**
 * Created by Pachon on 01.03.2015.
 */
public class Punctuation implements TextDividable{
    private String punctuation;

    public String getPunctuation() {
        return punctuation;
    }

    public Punctuation (String value){
        this.punctuation = value;
    }

    @Override
    public String merge(){
        return punctuation;
    }
}
