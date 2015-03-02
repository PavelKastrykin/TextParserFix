package com.pavel.textparser.entity;

import com.pavel.textparser.splitter.WordSplitter;

import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.util.List;

public class WordComplicated implements TextDividable{
    private List<TextDividable> arrayOfSubs;
    private WordSplitter wordSplitter = new WordSplitter();

    public List<TextDividable> getArrayOfSubs() {
        return arrayOfSubs;
    }

    public WordComplicated (String value){
        this.arrayOfSubs = wordSplitter.splitText(value);
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
