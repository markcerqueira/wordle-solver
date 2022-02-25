package com.wordlesolver

import org.junit.Test
import kotlin.test.assertEquals

class WordleGuessBreakdownTest {

    @Test
    fun `Test correct guess - apple, apple`() {
        assertEquals(wordleGuessBreakdown("apple", "apple").toString(), "🟩 🟩 🟩 🟩 🟩")
    }

    @Test
    fun `Test completely incorrect guess - could, irate`() {
        assertEquals(wordleGuessBreakdown("could", "irate").toString(), "⬛️ ⬛️ ⬛️ ⬛️ ⬛️")
    }

    @Test
    fun `Test partially incorrect position result - apple, pears`() {
        assertEquals(wordleGuessBreakdown("apple", "pears").toString(), "🟨 🟨 🟨 ⬛️ ⬛️")
    }

    @Test
    fun `Test partially correct result - shade, shack`() {
        assertEquals(wordleGuessBreakdown("shade", "shack").toString(), "🟩 🟩 🟩 ⬛️ ⬛️")
    }

    private fun wordleGuessBreakdown(correctWord: String, guessWord: String): WordleGuessBreakdown {
        return WordleGuessBreakdown(correctWord, guessWord)
    }
}
