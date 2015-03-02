package com.pavel.textparser.entity;

import com.pavel.textparser.splitter.SentenceSplitter;

import java.util.List;

public class Sentence implements TextDividable{
    private List<TextDividable> arrayOfSubs;
    private SentenceSplitter sentenceSplitter = new SentenceSplitter();

    public List<TextDividable> getArrayOfSubs() {
        return arrayOfSubs;
    }

    public Sentence (String value){
        this.arrayOfSubs = sentenceSplitter.splitText(value);
    }

    @Override
    public String merge(){
        StringBuilder sb = new StringBuilder();
        for (TextDividable x : this.arrayOfSubs){
            sb.append(x.merge());
        }
        return sb.toString();
    }
}
