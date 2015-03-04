package com.pavel.textparser.entity.primitive;

import com.pavel.textparser.entity.ParseableText;

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
