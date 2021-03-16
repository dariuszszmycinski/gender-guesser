package dasz.model;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    public static void main(String[] args) {
        testEwaJan();
    }
    public static void testEwaJan() {
        FileReader fileReader = new FileReader();
        Gender result = fileReader.checkNameInFile("Ewa");
        assertEquals(Gender.FEMALE, result);
        Gender result1 = fileReader.checkNameInFile("Jan");
        assertEquals(Gender.MALE, result1);
    }
}