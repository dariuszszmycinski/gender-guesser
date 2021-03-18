package dasz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckFirstNameTest {

    @Test
    void checkFirstName() {
        GenderChecker genderChecker = new GenderChecker();
        Gender result = genderChecker.checkName("Ewa Jan Maurycy", "firstName");
        assertEquals(Gender.FEMALE, result);
    }
}