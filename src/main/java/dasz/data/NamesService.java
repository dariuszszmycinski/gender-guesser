package dasz.data;

import dasz.model.Gender;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NamesService {
    private final String MALE_PATH = "src/main/resources/males.txt";
    private final String FEMALE_PATH = "src/main/resources/females.txt";

    public Gender checkNameInFile(String name) {
        String path1 = MALE_PATH;
        Gender gender1 = Gender.MALE;
        String path2 = FEMALE_PATH;
        Gender gender2 = Gender.FEMALE;
        if (name.endsWith("a")){ //Most Polish names ending with A is female, switch files search order
            path1 = FEMALE_PATH;
            path2 = MALE_PATH;
            gender1 = Gender.FEMALE;
            gender2 = Gender.MALE;
        }
        Gender result = this.verifyGender(name, path1, gender1);
        if (result == null) {
            result = this.verifyGender(name, path2, gender2);
        }
        if (result == null) {
            return Gender.INCONCLUSIVE;
        }
        return result;
    }

    private Gender verifyGender(String name, String path, Gender gender) {
        try (InputStream inputStream = new FileInputStream(path)) {
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    if (line.equals(name)) {
                        scanner.close();
                        return gender;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getNamesData() {
        List<String> namesData = new ArrayList<>();

        try (InputStream inputStream = new FileInputStream(MALE_PATH)) {
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                while (scanner.hasNextLine()) {
                    namesData.add(scanner.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (InputStream inputStream = new FileInputStream(FEMALE_PATH)) {
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                while (scanner.hasNextLine()) {
                    namesData.add(scanner.next());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.join(", ", namesData);
    }
}
