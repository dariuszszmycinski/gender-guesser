package dasz.model;

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
        try {
            inputStream = new FileInputStream(FEMALE_PATH);
            sc = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals(name)) {
                    return Gender.FEMALE;
                }
            }
            inputStream = new FileInputStream(MALE_PATH);
            sc = new Scanner(inputStream, StandardCharsets.UTF_8);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.equals(name)) {
                    return Gender.MALE;
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
