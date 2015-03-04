package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.ParseableText;

import java.util.List;

public interface Splitter {
    List<ParseableText> splitText(String string);
}
