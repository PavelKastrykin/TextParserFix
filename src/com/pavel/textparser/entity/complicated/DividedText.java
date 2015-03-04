package com.pavel.textparser.entity.complicated;

import com.pavel.textparser.entity.ParseableText;
import com.pavel.textparser.splitter.TextSplitter;

import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.util.List;

/**
 * Class DividedText contains text parts such as Paragraph and Code arranged to an ArrayList. Given text is divided
 * by rules and by means of described in TextSplitter class.
 */
public class DividedText implements ParseableText {

    private TextSplitter textSplitter = new TextSplitter();
    private List<ParseableText> arrayOfSubs;

    public List<ParseableText> getArrayOfSubs(){
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
        for (ParseableText x : this.arrayOfSubs){
            sb.append(x.merge());
        }
        return sb.toString();
    }

}
