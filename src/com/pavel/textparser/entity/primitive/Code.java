package com.pavel.textparser.entity.primitive;

import com.pavel.textparser.entity.ParseableText;

import java.lang.Override;
import java.lang.String;

/**
 * Class Code contains String representation, that describes some part of java-code in a given text
 */
public class Code implements ParseableText {

    private String codeValue;

    public String getCodeValue() {
        return codeValue;
    }

    public Code (String value){
        this.codeValue = value;
    }

    @Override
    public String merge() {
        return codeValue;
    }
}
