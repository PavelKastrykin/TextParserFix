package com.pavel.textparser.model.primitive;

import com.pavel.textparser.model.ParseableText;

/**
 * Class Punctuation contains symbols from the beginning and the end of WordComplicated as String
 */
public class Punctuation implements ParseableText {
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
