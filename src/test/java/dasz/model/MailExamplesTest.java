package dasz.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MailExamplesTest {

    @Test
    void checkName() {
        GenderChecker genderChecker = new GenderChecker();
        Gender result = genderChecker.checkName("Maria", "firstName");
        assertEquals(Gender.FEMALE, result);
        Gender result1 = genderChecker.checkName("Jan Maria Rokita", "firstName");
        assertEquals(Gender.MALE, result1);
        Gender result2 = genderChecker.checkName("Maria", "allName");
        assertEquals(Gender.FEMALE, result2);
        Gender result3 = genderChecker.checkName("Jan Maria Rokita", "allName");
        assertEquals(Gender.INCONCLUSIVE, result3);
        Gender result4 = genderChecker.checkName("Anna Gertruda", "allName");
        assertEquals(Gender.FEMALE, result4);
        Gender result5 = genderChecker.checkName("Zbigniew", "allName");
        assertEquals(Gender.MALE, result5);
        Gender result6 = genderChecker.checkName("Anna Gertruda Zbigniew", "allName");
        assertEquals(Gender.FEMALE, result6);
    }
}