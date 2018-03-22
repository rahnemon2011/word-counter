package com.javarightnow.wordcounter.util;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public final class WordCounter {

    private final static Logger LOGGER = Logger.getLogger(WordCounter.class);

    private WordCounter() {
    }

    public static WordCounterResult getFileContentDetails(String filePath) throws IOException {

        WordCounterResult wordCounterResult = new WordCounterResult();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordCounterResult.increaseLines();
                String[] words = line
                        .replaceAll("\\.|\\,", "\\s")
                        .replaceAll("\\s\\s", "\\s")
                        .trim()
                        .split("\\s");
                wordCounterResult.increaseWords(words.length);
                wordCounterResult.increaseCharacters( Stream.of(words).mapToInt(w -> w.length()).sum());
            }
        }

        return wordCounterResult;
    }

    public static class WordCounterResult {
        int lines = 0;
        int words = 0;
        int characters = 0;

        public int getLines() {
            return lines;
        }

        void increaseLines() {
            this.lines++;
        }

        public int getWords() {
            return words;
        }

        void increaseWords(int wordsCount) {
            this.words += wordsCount;
        }

        public int getCharacters() {
            return characters;
        }

        void increaseCharacters(int charactersCount) {
            this.characters += charactersCount;
        }
    }
} 