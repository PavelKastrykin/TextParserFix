package com.pavel.textparser.task;

import com.pavel.textparser.model.*;
import com.pavel.textparser.model.complicated.DividedText;
import com.pavel.textparser.model.complicated.Paragraph;
import com.pavel.textparser.model.complicated.Sentence;
import com.pavel.textparser.model.complicated.WordComplicated;
import com.pavel.textparser.model.primitive.WordSimple;

public class TaskChangeLetters {
    /*Преобразовать каждое слово в тексте, удалив из него все последующие (предыдущие) вхождения первой (последней)
    буквы этого слова*/

    private DividedText dividedText;
    public enum Position{
        FIRST, LAST;
    }

    private Position position;

    public TaskChangeLetters(DividedText dividedText, Position position){
        this.dividedText = dividedText;
        this.position = position;
    }

    public void execute(){
        for (ParseableText paragraph : dividedText.getArrayOfSubs()){
            if (paragraph instanceof Paragraph){
                for (ParseableText sentence : ((Paragraph) paragraph).getArrayOfSubs()){
                    for (ParseableText wordComplicated : ((Sentence)sentence).getArrayOfSubs()){
                        for (ParseableText word : ((WordComplicated)wordComplicated).getArrayOfSubs()){
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
