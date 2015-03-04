package com.pavel.textparser.entity;

import com.pavel.textparser.splitter.WordSplitter;

import java.lang.Override;import java.lang.String;import java.lang.StringBuilder;import java.util.List;

/**
 * Class WordComplicated contains text parts such as WordSimple and Punctuation arranged to an ArrayList.
 * Given Sentence is divided by rules and by means of described in WordSplitter class.
 */
public class WordComplicated implements TextDividable{
    private List<TextDividable> arrayOfSubs;
    private WordSplitter wordSplitter = new WordSplitter();

    public List<TextDividable> getArrayOfSubs() {
        return arrayOfSubs;
    }

    public WordComplicated (String value){
        this.arrayOfSubs = wordSplitter.splitText(value);
    }

    /**
     * @return returns String representation of WordComplicated by merging its parts: WordCSimple and Punctuation as String
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
