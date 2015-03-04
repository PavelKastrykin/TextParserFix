package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.complicated.Sentence;
import com.pavel.textparser.entity.ParseableText;

import java.lang.String;import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *Splits Paragraph into ArrayList of <Sentence>.
 */
public class ParagraphSplitter implements Splitter{

    public List<ParseableText> splitText(String string){
        List<ParseableText> arrayOfSentences = new ArrayList<ParseableText>();
        while (string.length() > 0){
            String textPart = string.substring(0, RegExp.matcherPatternIndex(string, RegExp.SENTENCE_END_PATTERN) + 1);
            arrayOfSentences.add(new Sentence(textPart));
            string = string.replaceFirst(Pattern.quote(textPart), "");
        }
        return arrayOfSentences;
    }
}
