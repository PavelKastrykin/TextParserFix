package com.pavel.textparser.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class TextManager is used to read text from text-file and to return the content of File as a String.
 */
public class UniversalFileReader {

    public static String readFile(String filename) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()){
            sb.append(reader.readLine()).append("\n");
        }
        return sb.toString();

    }
}
