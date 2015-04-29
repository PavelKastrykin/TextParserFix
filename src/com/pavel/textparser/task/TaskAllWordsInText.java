package com.pavel.textparser.task;

import com.pavel.textparser.model.*;
import com.pavel.textparser.model.complicated.DividedText;
import com.pavel.textparser.model.complicated.Paragraph;
import com.pavel.textparser.model.complicated.Sentence;
import com.pavel.textparser.model.complicated.WordComplicated;
import com.pavel.textparser.model.primitive.WordSimple;

import java.lang.String;
import java.util.*;

public class TaskAllWordsInText {
    /*Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать
    с красной строки.*/
    private DividedText dividedText;
    private ArrayList<String> allWordsInText;
    private ArrayList<String> allWordsInTextNoDuplicatesSorted;

    public TaskAllWordsInText(DividedText dividedText){
        this.dividedText = dividedText;
        allWordsInText = allWordsInTextCreator(dividedText);
        allWordsInTextNoDuplicatesSorted = sortWordsNoDuplicates(allWordsInText);
    }

    private ArrayList<String> allWordsInTextCreator(DividedText dividedText){
        ArrayList<String> allWords = new ArrayList<String>();
        for (ParseableText paragraph : dividedText.getArrayOfSubs()){
            if (paragraph instanceof Paragraph){
                for (ParseableText sentence : ((Paragraph) paragraph).getArrayOfSubs()){
                    for (ParseableText wordComplicated : ((Sentence)sentence).getArrayOfSubs()){
                        for (ParseableText word : ((WordComplicated)wordComplicated).getArrayOfSubs()){
                            if (word instanceof WordSimple){
                                allWords.add(word.merge().toLowerCase());
                            }
                        }
                    }
                }
            }
        }
        return allWords;
    }

    private ArrayList<String> sortWordsNoDuplicates(List<String> arrayList){
        ArrayList<String> sortedWordsNoDuplicates = new ArrayList<String>();
        HashSet<String> hashSet = new HashSet<String>();
        hashSet.addAll(arrayList);
        sortedWordsNoDuplicates.addAll(hashSet);
        Collections.sort(sortedWordsNoDuplicates);
        return sortedWordsNoDuplicates;
    }

    public void execute(){
        StringBuilder sb = new StringBuilder();
        int i = 97;
        for (String x : allWordsInTextNoDuplicatesSorted){
            if (x.charAt(0) == (char)i){
                sb.append(x + " ");
            }
            else {
                sb.append("\n" + x + " ");
                i = (int)(x.charAt(0));
            }
        }
    }
}
