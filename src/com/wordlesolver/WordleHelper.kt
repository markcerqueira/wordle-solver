package com.wordlesolver

import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files
import kotlin.random.Random

class WordleHelper {
    val allWordleWords: List<String> = Files.readAllLines(File("resources/allowed_words.txt").toPath(), Charset.defaultCharset())

    fun randomWordle(): String {
        return allWordleWords[Random.nextInt(allWordleWords.size)]
    }
}
