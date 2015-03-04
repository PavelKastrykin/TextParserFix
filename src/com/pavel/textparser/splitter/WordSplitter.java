package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.Punctuation;
import com.pavel.textparser.entity.TextDividable;
import com.pavel.textparser.entity.WordSimple;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Splits WordComplicated into combined ArrayList of <WordSimple> and <Punctuation>
 */
public class WordSplitter {

    public List<TextDividable> splitText(String string){
        List<TextDividable> arrayOfSimpleWordsAndPunctuation = new ArrayList<TextDividable>();
        while (string.length() > 0){
            if(!string.matches("^[a-zA-Z].*$")){
                arrayOfSimpleWordsAndPunctuation.add(new Punctuation(string.substring(0, 1)));
                string = string.substring(1, string.length());
                continue;
            }
            Pattern pattern = Pattern.compile(RegExp.SIMPLE_WORD_MATCH_PATTERN);
            Matcher matcher = pattern.matcher(string);
            if (matcher.find()){
                String textPart = string.substring(0, matcher.end());
                arrayOfSimpleWordsAndPunctuation.add(new WordSimple(textPart));
                string = string.replaceFirst(Pattern.quote(textPart), "");
            }

        }
        return arrayOfSimpleWordsAndPunctuation;
    }
}
