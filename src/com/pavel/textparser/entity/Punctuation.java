package com.pavel.textparser.entity;

/**
 * Class Punctuation contains symbols from the beginning and the end of WordComplicated as String
 */
public class Punctuation implements TextDividable{
    private String punctuation;

    public String getPunctuation() {
        return punctuation;
    }

    public Punctuation (String value){
        this.punctuation = value;
    }

    /**
     * @return String representation of Punctuation
     */
    @Override
    public String merge(){
        return punctuation;
    }
}
