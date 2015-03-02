package com.pavel.textparser.entity;

import java.lang.Override;import java.lang.String;public class Code implements TextDividable{

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
