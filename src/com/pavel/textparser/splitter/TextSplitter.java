package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.*;
import com.pavel.textparser.entity.complicated.Paragraph;
import com.pavel.textparser.entity.primitive.Code;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Splits TextDivadable into combined ArrayList of <Paragraph> and <Code>
 */
public class TextSplitter implements Splitter{

    public List<ParseableText> splitText(String string){
        List<ParseableText> arrayOfParagraphs = new ArrayList<ParseableText>();
        boolean isText = true;
        while (string.length() > 0){
            if (isText){
                String textPart = string.substring(0, RegExp.matcherPatternIndex(string, RegExp.CODE_START_PATTERN) + 1);
                arrayOfParagraphs.add(new Paragraph(textPart));
                string = string.replaceFirst(Pattern.quote(textPart), "");
                isText = !isText;
                continue;
            }
            if (!isText){
                String textPart = string.substring(0, RegExp.matcherPatternIndex(string, RegExp.CODE_END_PATTERN) + 4);
                arrayOfParagraphs.add(new Code(textPart));
                string = string.replaceFirst(Pattern.quote(textPart), "");
                isText = !isText;
            }
        }
        return arrayOfParagraphs;
    }
}
