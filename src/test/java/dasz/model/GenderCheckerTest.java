package dasz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderCheckerTest {

    @Test
    void checkAllNames() {
        GenderChecker genderChecker = new GenderChecker();
        Gender result = genderChecker.checkName("Ewa Jan Maurycy", "allNames");
        assertEquals(Gender.MALE, result);
        Gender result1 = genderChecker.checkName("Ewa Jan", "allNames");
        assertEquals(Gender.INCONCLUSIVE, result1);
    }
}