package com.javarightnow.wordcounter;

import com.javarightnow.wordcounter.util.WordCounter;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @author hadi
 */
public class WordCounterMain {

    private final static Logger LOGGER = Logger.getLogger(WordCounterMain.class);

    private static final String fileToCount = "example.txt";

    public static void main(String[] args) {

        WordCounter.WordCounterResult result = null;
        try {
            ClassLoader classLoader = WordCounterMain.class.getClassLoader();
            String path = classLoader.getResource(fileToCount).getPath();
            result = WordCounter.getFileContentDetails(path);
        } catch (IOException e) {
            LOGGER.error("Problem in reading the example file" + e.getMessage());
        }

        LOGGER.debug("lines: " + result.getLines());
        LOGGER.debug("words: " + result.getWords());
        LOGGER.debug("characters: " + result.getCharacters());
    }

}


