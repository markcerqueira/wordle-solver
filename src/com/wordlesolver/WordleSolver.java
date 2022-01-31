package com.wordlesolver;

public class WordleSolver {

    public static void main(String[] args) throws Exception {
        WordleHelper wordleHelper = new WordleHelper();

        System.out.println("Total words in our dictionary = " + wordleHelper.getAllEnglishWords().size());
        System.out.println("Total five-letter words in our dictionary = " + wordleHelper.getAllFiveLetterEnglishWords().size() + "\n");

        for (int i = 0; i < 1; i++) {
            WorldChallenge wordleChallenge = new WorldChallenge(wordleHelper.randomWordle());

            String guessWord = wordleHelper.randomWordle();

            while (wordleChallenge.guess(wordleHelper.randomWordle()).getSummary() != WordleGuessResultSummary.CORRECT) {

            }

            System.out.println("It took " + wordleChallenge.getTotalGuesses() + " guesses to get it right");
        }
    }
}
