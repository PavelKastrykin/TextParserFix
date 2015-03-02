package com.pavel.textparser.entity;

import com.pavel.textparser.splitter.ParagraphSplitter;

import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.util.List;

public class Paragraph implements TextDividable {

    private List<TextDividable> arrayOfSubs;
    private ParagraphSplitter paragraphSplitter = new ParagraphSplitter();

    public List<TextDividable> getArrayOfSubs() {
        return arrayOfSubs;
    }

    public Paragraph(String value){
        this.arrayOfSubs = paragraphSplitter.splitText(value);
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
