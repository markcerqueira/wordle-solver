package com.wordlesolver;

public class WordleSolver {

    public static void main(String[] args) throws Exception {
        WordleHelper wordleHelper = new WordleHelper();

        System.out.println("Total words in our dictionary = " + wordleHelper.getAllEnglishWords().size());
        System.out.println("Total five-letter words in our dictionary = " + wordleHelper.getAllFiveLetterEnglishWords().size());
    }
}
