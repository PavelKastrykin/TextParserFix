package com.pavel.textparser.model.complicated;

import com.pavel.textparser.model.ParseableText;
import com.pavel.textparser.splitter.SentenceSplitter;

import java.util.List;

/**
 * Class Sentence contains text parts such as WordComplicated arranged to an ArrayList. Given Sentence is divided
 * by rules and by means of described in SentenceSplitter class.
 */

public class Sentence implements ParseableText {
    private List<ParseableText> arrayOfSubs;
    private SentenceSplitter sentenceSplitter = new SentenceSplitter();

    public List<ParseableText> getArrayOfSubs() {
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
        for (ParseableText x : this.arrayOfSubs){
            sb.append(x.merge());
        }
        return sb.toString();
    }
}
