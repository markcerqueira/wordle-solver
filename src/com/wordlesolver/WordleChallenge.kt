package com.wordlesolver

data class WorldChallenge @JvmOverloads constructor(
    val correctWord: String,
    val allowedGuesses: Int = 6,
) {
    var totalGuesses = 0
    var previousGuesses = mutableSetOf<String>()
    var solved = false

    init {
        println("New WordleChallenge initialized with correct answer $correctWord")
    }

    companion object {
        var wordleHelper = WordleHelper()
    }

    fun guess(guessWord: String): WordleGuessResult {
        // println("Guessing the word is $guessWord")

        if (!wordleHelper.allFiveLetterEnglishWords.contains(guessWord)) {
            // println("\tReturning NOT_A_WORD as $guessWord is not a valid word")
            return WordleGuessResult(WordleGuessResultSummary.NOT_A_WORD)
        }

        if (previousGuesses.contains(guessWord)) {
            // println("\tReturning DUPLICATE_GUESS as $guessWord has already been used")
            return WordleGuessResult(WordleGuessResultSummary.DUPLICATE_GUESS)
        }

        totalGuesses++
        previousGuesses.add(guessWord)

        val wordleGuessBreakdown = WordleGuessBreakdown(correctWord, guessWord)

        return if (guessWord == correctWord) {
            // println("\tReturning CORRECT as $guessWord is the correct word")
            solved = true
            WordleGuessResult(WordleGuessResultSummary.CORRECT, wordleGuessBreakdown)
        } else {
            // println("\tReturning INCORRECT as $guessWord is not the correct word")
            WordleGuessResult(WordleGuessResultSummary.INCORRECT, wordleGuessBreakdown)
        }
    }
}

data class WordleGuessResult(
    public val summary: WordleGuessResultSummary,
    public val wordleGuessBreakdown: WordleGuessBreakdown? = null
)

enum class WordleGuessResultSummary {
    CORRECT,
    INCORRECT,
    NOT_A_WORD,
    DUPLICATE_GUESS
}
