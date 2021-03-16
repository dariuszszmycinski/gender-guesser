package dasz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void checkNameInFile() {
        FileReader fileReader = new FileReader();
        Gender result = fileReader.checkNameInFile("Ewa");
        assertEquals(Gender.FEMALE, result);
        Gender result1 = fileReader.checkNameInFile("Jan");
        assertEquals(Gender.MALE, result1);
    }
}