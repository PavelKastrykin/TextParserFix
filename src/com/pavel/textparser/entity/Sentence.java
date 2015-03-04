package com.pavel.textparser.entity;

import com.pavel.textparser.splitter.SentenceSplitter;

import java.util.List;

/**
 * Class Sentence contains text parts such as WordComplicated arranged to an ArrayList. Given Sentence is divided
 * by rules and by means of described in SentenceSplitter class.
 */

public class Sentence implements TextDividable{
    private List<TextDividable> arrayOfSubs;
    private SentenceSplitter sentenceSplitter = new SentenceSplitter();

    public List<TextDividable> getArrayOfSubs() {
        return arrayOfSubs;
    }

    public Sentence (String value){
        this.arrayOfSubs = sentenceSplitter.splitText(value);
    }

    /**
     * @return returns String representation of Sentence by merging its parts: WordComplicated as String
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
