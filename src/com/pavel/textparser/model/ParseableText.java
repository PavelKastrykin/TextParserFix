package com.pavel.textparser.model;

/**
 * Interface ParseableText describes parts of a text, that can be divided into sub-parts. All sub-parts also must
 * implement interface ParseableText. Objects of ParseableText must override method merge() that returns either String
 * representation of classes Code, WordSimple and Punctuation, or merged sub-parts, stored in ArrayList-field of classes
 * DividedText, Paragraph, Sentence and WordComplicated.
 */

public interface ParseableText {
    String merge();
}
