package org.example.filemanager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    @DisplayName("getFileName pass null string")
    void getFileName_WHEN_null_THEN_empty() {
        /*FileReader fileReaderMock = Mockito.mock(FileReader.class);
        fileReaderMock.setDestinationPath(null);
        Mockito.when(fileReaderMock.loadFiles(List.of(""))).thenReturn();*/
        String nullString = null;

        assertThrows(IllegalArgumentException.class, () -> FileReader.getFileName(nullString));
    }

    @Test
    @DisplayName("getFileName pass empty string")
    void getFileName_WHEN_empty_THEN_empty() {
        String emptyString = "";

        assertThrows(IllegalArgumentException.class, () -> FileReader.getFileName(emptyString));
    }

    @Test
    @DisplayName("getFileName pass correct string")
    void getFileName_WHEN_notingToChange() {
        String inputString = "/abcde.fgh.123((()";

        assertEquals("abcde.fgh.123((()", FileReader.getFileName(inputString));
    }

    @Test
    @DisplayName("getFileName pass string with one change")
    void getFileName_WHEN_oneLetterToChange() {
        String inputString = "/abcde.fgh.12:3((()";

        assertEquals("abcde.fgh.12%3((()", FileReader.getFileName(inputString));
    }

    @Test
    @DisplayName("getFileName pass string with several changes")
    void getFileName_WHEN_severalLetterToChange() {
        String inputString = "|/abcde.fgh?.12::3((()|";

        assertEquals("abcde.fgh%.12%%3((()%", FileReader.getFileName(inputString));
    }

    @Test
    @DisplayName("getFileName pass string which is not a path")
    void getFileName_WHEN_givenStringIsNotPath() {
        String inputString = "notpath";

        assertThrows(IllegalArgumentException.class, () -> FileReader.getFileName(inputString));
    }

    @Test
    @DisplayName("load files when destination path is empty")
    void loadFiles_WHEN_destPath_empty() {
        FileReader reader = new FileReader();
        reader.setDestinationPath(null);

        assertThrows(UnsupportedOperationException.class, () -> reader.loadFiles(List.of()));
    }
}