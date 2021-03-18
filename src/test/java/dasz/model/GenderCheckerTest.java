package dasz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenderCheckerTest {

    @Test
    void checkAllNames() {
        GenderChecker genderChecker = new GenderChecker();
        Gender result = genderChecker.checkAllNames("Ewa Jan Maurycy");
        assertEquals(Gender.MALE, result);
        Gender result1 = genderChecker.checkAllNames("Ewa Jan");
        assertEquals(Gender.INCONCLUSIVE, result1);
    }
}