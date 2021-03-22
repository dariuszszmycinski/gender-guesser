package dasz.model;

import dasz.data.NamesService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NamesServiceTest {

    @Test
    void checkNameInFile() {
        NamesService namesService = new NamesService();
        Gender result = namesService.checkNameInFile("Ewa");
        assertEquals(Gender.FEMALE, result);
        Gender result1 = namesService.checkNameInFile("Jan");
        assertEquals(Gender.MALE, result1);
    }
}