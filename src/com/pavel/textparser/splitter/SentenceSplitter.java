package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.TextDividable;
import com.pavel.textparser.entity.WordComplicated;

import java.lang.String;import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class SentenceSplitter {
    private List<String> sentenceSplitted = new ArrayList<String>();

    public List<String> getSentenceSplitted(){
        return this.sentenceSplitted;
    }

    public List<TextDividable> splitText(String string){

        List<TextDividable> arrayOfComplicatedWords = new ArrayList<TextDividable>();
        while (string.length() > 0){
            String textPart = string.substring(0, RegExp.matcherPatternIndex(string, RegExp.WORD_END_PATTERN) + 1);
            arrayOfComplicatedWords.add(new WordComplicated(textPart));
            string = string.replaceFirst(Pattern.quote(textPart), "");
        }
        return arrayOfComplicatedWords;
    }
}
