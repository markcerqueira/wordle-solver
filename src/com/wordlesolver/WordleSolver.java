package com.wordlesolver;

public class WordleSolver {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 1; i++) {
            WorldChallenge wordleChallenge = new WorldChallenge("shack");

            System.out.println("S H D A E");

            WordleGuessResult wordleGuessResult = wordleChallenge.guess("shade");
            System.out.println("S H A A A");
            System.out.println(wordleGuessResult.getWordleGuessBreakdown());

            // System.out.println("It took " + wordleChallenge.getTotalGuesses() + " guesses to get it right");
        }
    }
}
