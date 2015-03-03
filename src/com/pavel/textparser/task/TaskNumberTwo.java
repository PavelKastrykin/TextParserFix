package com.pavel.textparser.task;

import com.pavel.textparser.entity.*;

import java.util.ArrayList;

public class TaskNumberTwo {

    private DividedText dividedText;
    public enum Position{
        FIRST, LAST;
    }

    private Position position;

    public TaskNumberTwo(DividedText dividedText, Position position){
        this.dividedText = dividedText;
        this.position = position;
    }

    public void execute(){
        for (TextDividable paragraph : dividedText.getArrayOfSubs()){
            if (paragraph instanceof Paragraph){
                for (TextDividable sentence : ((Paragraph) paragraph).getArrayOfSubs()){
                    for (TextDividable wordComplicated : ((Sentence)sentence).getArrayOfSubs()){
                        for (TextDividable word : ((WordComplicated)wordComplicated).getArrayOfSubs()){
                            if (word instanceof WordSimple){
                                ((WordSimple) word).setWordSimple(replaceChars(((WordSimple) word).getWordSimple(), position));
                            }
                        }
                    }
                }
            }
        }
    }

    private String replaceChars(String word, Position position){
        String element;
        switch (position){
            case FIRST:
                element = word.substring(0,1);
                word = word.replaceAll(element, "");
                word = word.replaceAll(element.toLowerCase(), "");
                word = element + word;
                break;
            default:
                element = word.substring(word.length() - 1, word.length());
                word = word.replaceAll(element, "");
                word = word.replaceAll(element.toUpperCase(), "");
                word = word + element;
                break;
        }
        return word;
    }
}
