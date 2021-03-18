package dasz.model;

import dasz.data.FileReader;

public class GenderChecker {
    FileReader fileReader = new FileReader();

    public Gender checkName(String names, String variant) {
        if (variant.equals("firstName")) {
            return checkFirstName(names);
        }
        return checkAllNames(names);
    }

    private Gender checkFirstName(String names) {
        String firstName = names.split(" ")[0];
        return fileReader.checkNameInFile(firstName);
    }

    private Gender checkAllNames(String names) {
        String[] allNames = names.split(" ");
        int males = 0;
        int females = 0;
        int inconclusive = 0;
        for (String s : allNames) {
            Gender gender = fileReader.checkNameInFile(s);
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
