package com.pavel.textparser.splitter;

import com.pavel.textparser.model.ParseableText;
import com.pavel.textparser.model.complicated.WordComplicated;

import java.lang.String;import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Splits Sentences into ArrayList of <WordComplicated>
 */
public class SentenceSplitter implements Splitter{
    private List<String> sentenceSplitted = new ArrayList<String>();

    public List<String> getSentenceSplitted(){
        return this.sentenceSplitted;
    }

    public List<ParseableText> splitText(String string){

        List<ParseableText> arrayOfComplicatedWords = new ArrayList<ParseableText>();
        while (string.length() > 0){
            String textPart = string.substring(0, RegExp.matcherPatternIndex(string, RegExp.WORD_END_PATTERN) + 1);
            arrayOfComplicatedWords.add(new WordComplicated(textPart));
            string = string.replaceFirst(Pattern.quote(textPart), "");
        }
        return arrayOfComplicatedWords;
    }
}
