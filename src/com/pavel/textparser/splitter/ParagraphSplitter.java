package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.Sentence;
import com.pavel.textparser.entity.TextDividable;

import java.lang.String;import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *Splits Paragraph into ArrayList of <Sentence>.
 */
public class ParagraphSplitter implements Splitter{

    public List<TextDividable> splitText(String string){
        List<TextDividable> arrayOfSentences = new ArrayList<TextDividable>();
        while (string.length() > 0){
            String textPart = string.substring(0, RegExp.matcherPatternIndex(string, RegExp.SENTENCE_END_PATTERN) + 1);
            arrayOfSentences.add(new Sentence(textPart));
            string = string.replaceFirst(Pattern.quote(textPart), "");
        }
        return arrayOfSentences;
    }
}
