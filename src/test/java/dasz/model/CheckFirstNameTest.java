package dasz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckFirstNameTest {

    @Test
    void checkFirstName() {
        GenderChecker genderChecker = new GenderChecker();
        Gender result = genderChecker.checkFirstName("Ewa Jan Maurycy");
        assertEquals(Gender.FEMALE, result);
    }
}