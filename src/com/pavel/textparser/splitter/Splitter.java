package com.pavel.textparser.splitter;

import com.pavel.textparser.entity.TextDividable;

import java.util.List;

public interface Splitter {
    List<TextDividable> splitText(String string);
}
