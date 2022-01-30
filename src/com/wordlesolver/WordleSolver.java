package com.wordlesolver;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class WordleSolver {

    public static void main(String[] args) throws Exception {
        List<String> allEnglishWords = Files.readAllLines(new File("resources/all-english-words.txt").toPath(), Charset.defaultCharset());

        System.out.println("Total words in our dictionary = " + allEnglishWords.size());

        List<String> fiveLetterWords = allEnglishWords.stream().filter(word -> word.length() == 5).toList();

        System.out.println("Total five-letter words in our dictionary = " + fiveLetterWords.size());
    }
}
