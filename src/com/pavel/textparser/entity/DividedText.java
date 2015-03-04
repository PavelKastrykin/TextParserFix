package com.pavel.textparser.entity;

import com.pavel.textparser.splitter.TextSplitter;

import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.util.List;

/**
 * Class DividedText contains text parts such as Paragraph and Code arranged to an ArrayList. Given text is divided
 * by rules and by means of described in TextSplitter class.
 */
public class DividedText implements TextDividable {

    private TextSplitter textSplitter = new TextSplitter();
    private List<TextDividable> arrayOfSubs;

    public List<TextDividable> getArrayOfSubs(){
        return this.arrayOfSubs;
    }

    public DividedText(String value){
        this.arrayOfSubs = textSplitter.splitText(value);
    }

    /**
     *
     * @return returns String representation of given text by merging its parts : Paragraph and Code as String
     */
    @Override
    public String merge(){
        StringBuilder sb = new StringBuilder();
        for (TextDividable x : this.arrayOfSubs){
            sb.append(x.merge());
        }
        return sb.toString();
    }

}
