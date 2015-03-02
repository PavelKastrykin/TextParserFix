package com.pavel.textparser.task;

import com.pavel.textparser.entity.*;

import java.lang.String;
import java.util.*;

public class TaskNumberOne {
    //Напечатать слова текста в алфавитном порядке по первой букве. Слова, начинающиеся с новой буквы, печатать
    //с красной строки.
    private DividedText dividedText;

    public DividedText getDividedText() {
        return dividedText;
    }

    private ArrayList<String> allWordsInText;
    private ArrayList<String> allWordsInTextNoDuplicatesSorted;

    public TaskNumberOne(DividedText dividedText){
        this.dividedText = dividedText;
        allWordsInText = allWordsInTextCreator(dividedText);
        allWordsInTextNoDuplicatesSorted = sortWordsNoDuplicates(allWordsInText);
    }

    public ArrayList<String> allWordsInTextCreator(DividedText dividedText){
        ArrayList<String> allWords = new ArrayList<String>();
        for (TextDividable paragraph : dividedText.getArrayOfSubs()){
            if (paragraph instanceof Paragraph){
                for (TextDividable sentence : ((Paragraph) paragraph).getArrayOfSubs()){
                    for (TextDividable wordComplicated : ((Sentence)sentence).getArrayOfSubs()){
                        for (TextDividable word : ((WordComplicated)wordComplicated).getArrayOfSubs()){
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

}
