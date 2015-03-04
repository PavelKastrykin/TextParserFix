package com.pavel.textparser.entity;

/**
 * Interface TextDividable describes parts of a text, that can be divided into sub-parts. All sub-parts also must
 * implement interface TexDividable. Objects of TextDividable must override method merge() that returns either String
 * representation of classes Code, WordSimple and Punctuation, or merged sub-parts? stored in ArrayList-field of classes
 * DividedText, Paragraph, Sentence and WordComplicated.
 */

public interface TextDividable {
    String merge();
}
