package com.pavel.textparser.splitter;

import java.lang.String;import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitterRegExp {
    public static final String CODE_START_PATTERN = "\n[public|private|protected|void|class|try]";
    public static final String CODE_END_PATTERN = "\\}\n\\}\n|\\;\n\\}\n";
    public static final String SENTENCE_END_PATTERN = ".{1}\n|\\. |\\! |\\? ";
    public static final String WORD_END_PATTERN = " ";
    public static final String SIMPLE_WORD_MATCH_PATTERN = ".*[a-zA-Z]";

    public static int matcherPatternIndex(String text, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return matcher.start();
        }
        return text.length() -1;
    }

    public static int matcherLastPatternIndex(String text, String regex){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return matcher.end();
        }
        return text.length() -1;
    }
}
