package com.pavel.textparser.model.primitive;

import com.pavel.textparser.model.ParseableText;

import java.lang.Override;
import java.lang.String;

public class WordSimple implements ParseableText {
    private String wordSimple;

    public String getWordSimple(){
        return wordSimple;
    }
    public void setWordSimple(String value){
        this.wordSimple = value;
    }

    public WordSimple (String value){
        this.wordSimple = value;
    }

    @Override
    public String merge(){
        return this.wordSimple;
    }
}
