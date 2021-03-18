package dasz.data;

import dasz.model.Gender;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReader {
    private final String MALE_PATH = "src/main/resources/males.txt";
    private final String FEMALE_PATH = "src/main/resources/females.txt";

    public Gender checkNameInFile(String name) {
        FileInputStream inputStream = null;
        Scanner sc = null;
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
        try {
            inputStream = new FileInputStream(path1);
            sc = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals(name)) {
                    return gender1;
                }
            }
            inputStream = new FileInputStream(path2);
            sc = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals(name)) {
                    return gender2;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sc != null) {
                sc.close();
            }
        }
        return Gender.INCONCLUSIVE;
    }
}
