package com.pavel.textparser.splitter;

import com.pavel.textparser.model.ParseableText;

import java.util.List;

public interface Splitter {
    List<ParseableText> splitText(String string);
}
