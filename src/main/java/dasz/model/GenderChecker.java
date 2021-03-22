package dasz.model;

import dasz.data.NamesService;

public class GenderChecker {
    NamesService namesService = new NamesService();

    public Gender checkName(String names, String variant) {
        if (variant.equals("firstName")) {
            return checkFirstName(names);
        }
        return checkAllNames(names);
    }

    private Gender checkFirstName(String names) {
        String firstName = names.split(" ")[0];
        return namesService.checkNameInFile(firstName);
    }

    private Gender checkAllNames(String names) {
        String[] allNames = names.split(" ");
        int males = 0;
        int females = 0;
        int inconclusive = 0;
        for (String s : allNames) {
            Gender gender = namesService.checkNameInFile(s);
            switch (gender) {
                case MALE -> males++;
                case FEMALE -> females++;
                case INCONCLUSIVE -> inconclusive++;
            }
        }
        if (males > females && males > inconclusive) {
            return Gender.MALE;
        } else if (females > males && females > inconclusive) {
            return Gender.FEMALE;
        }
        return Gender.INCONCLUSIVE;
    }
}
