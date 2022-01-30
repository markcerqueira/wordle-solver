package com.wordlesolver

import java.io.File
import java.nio.charset.Charset
import java.nio.file.Files

class WordleHelper {
    val allEnglishWords: List<String> = Files.readAllLines(File("resources/all-english-words.txt").toPath(), Charset.defaultCharset())
    val allFiveLetterEnglishWords: List<String> = allEnglishWords.filter { it.length == 5 }
}
