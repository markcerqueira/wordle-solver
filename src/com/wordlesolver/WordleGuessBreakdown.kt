package com.wordlesolver

data class WordleGuessBreakdown(
    val correctWord: String,
    val guessWord: String
) {

    var letterResults = mutableListOf<LetterResult>()

    init {
        val correctWordList = mutableListOf<Char>()
        correctWordList.addAll(correctWord.toCharArray().toList())

        val guessWordList = mutableListOf<Char>()
        guessWordList.addAll(guessWord.toCharArray().toList())

        for (i in 0..4) {
            letterResults.add(i, LetterResult.INCORRECT_NEVER_PRESENT)
        }

        for ((index, guessChar) in guessWordList.withIndex()) {
            val correctChar = correctWord.toCharArray()[index]
            if (guessChar == correctChar) {
                letterResults.set(index, LetterResult.CORRECT)
                correctWordList[index] = '0'
            }
        }

        for ((index, guessChar) in guessWordList.withIndex()) {
            if (correctWordList[index] == '0') {
                continue
            }

            if (correctWordList.contains(guessChar)) {
                letterResults.set(index, LetterResult.INCORRECT_POSITION)
                correctWordList[correctWord.indexOf(guessChar)] = '0'
            } else {
                letterResults.set(index, LetterResult.INCORRECT_NEVER_PRESENT)
            }
        }
    }

    override fun toString(): String {
        return letterResults.map { it.representation }.joinToString(" ")
    }
}

enum class LetterResult(val representation: String) {
    CORRECT("🟩"),
    INCORRECT_NEVER_PRESENT("⬛️"),
    INCORRECT_POSITION("🟨")
}
