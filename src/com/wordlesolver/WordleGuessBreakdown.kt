package com.wordlesolver

data class WordleGuessBreakdown(
    val correctWord: String,
    val guessWord: String
) {

    var letterResults = mutableListOf<LetterResult>()

    init {
        for (i in correctWord.indices) {
            letterResults.add(i, if (correctWord[i] == guessWord[i]) LetterResult.CORRECT else LetterResult.INCORRECT)
        }
    }
}

enum class LetterResult {
    CORRECT,
    INCORRECT
}
