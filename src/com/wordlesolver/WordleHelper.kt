package com.wordlesolver

import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import kotlin.random.Random

class WordleHelper {
    val allEnglishWords: List<String> = Files.readAllLines(File("resources/all-english-words.txt").toPath(), Charset.defaultCharset())
    // TODO All to lower / de-dupe with set
    val allFiveLetterEnglishWords: List<String> = allEnglishWords.filter { it.length == 5 && it.none { it in 'A'..'Z' } }

    fun randomWordle(): String {
        return allFiveLetterEnglishWords[Random.nextInt(allFiveLetterEnglishWords.size)]
    }
}
