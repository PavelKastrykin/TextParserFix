package com.pavel.textparser.main;

import com.pavel.textparser.task.TaskAllWordsInText;
import com.pavel.textparser.model.complicated.DividedText;
import com.pavel.textparser.util.UniversalFileReader;
import com.pavel.textparser.task.TaskChangeLetters;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;import java.lang.String;

public class MainApplication {

    public static Logger logger = Logger.getLogger(MainApplication.class);

    public static void main (String[] args) throws IOException{


        String text = "";
        try {
            text = UniversalFileReader.readFile("e:/1.txt");
        }
        catch (FileNotFoundException e){
            logger.error("File was not found!", e);
        }
        catch (IOException e){
            logger.error("Problem reading file!", e);
        }

        DividedText dividedText = new DividedText(text);

        TaskAllWordsInText taskAllWordsInText = new TaskAllWordsInText(dividedText);
        taskAllWordsInText.execute();

        TaskChangeLetters taskChangeLetters = new TaskChangeLetters(dividedText, TaskChangeLetters.Position.LAST);
        taskChangeLetters.execute();

        System.out.println(dividedText.merge());
    }
}
