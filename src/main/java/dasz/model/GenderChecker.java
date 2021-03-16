package dasz.model;

public class GenderChecker {
    FileReader fileReader = new FileReader();

    public Gender checkFirstName(String names){
        String firstName = names.split(" ")[0];
        return fileReader.checkNameInFile(firstName);
    }
}
