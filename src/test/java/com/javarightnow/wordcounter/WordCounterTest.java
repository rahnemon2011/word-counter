package com.javarightnow.wordcounter;

import com.javarightnow.wordcounter.util.WordCounter;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    private static String path;

    @BeforeClass
    public static void setup() {
        String fileName = "example.txt";
        ClassLoader classLoader = WordCounterTest.class.getClassLoader();
        path = classLoader.getResource(fileName).getPath();
    }

    @Test
    public void fileContentDetails_correctFilePath_haveResult() throws IOException {
        int expectedLines = 5;
        int expectedWords = 9;
        int expectedCharacters = 43;

        WordCounter.WordCounterResult result = WordCounter.getFileContentDetails(path);

        assertEquals("expect 5 lines", expectedLines, result.getLines());
        assertEquals("expect 9 words", expectedWords, result.getWords());
        assertEquals("expect 43 characters", expectedCharacters, result.getCharacters());
    }

    @Test(expected = FileNotFoundException.class)
    public void fileContentDetails_wrongFilePath_throwsException() throws IOException {
        WordCounter.getFileContentDetails("/fexcvr/" + path);
    }
}