package main.java.sgu.ru;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class C1 {
    private static String parse_file(String raw) {
        String letters = "[А-ЯЁA-Z&&[^ЪЬ]][а-яёa-z]";
        Pattern halfName = Pattern.compile("%s* %s*.*".formatted(letters, letters));
        Pattern fullName = Pattern.compile("%s* %s* %s*.*".formatted(letters, letters, letters));
        String[] wordList = raw.split("\\s+");

        if (fullName.matcher(raw).matches()) {
            String sur = wordList[0];
            String name = wordList[1];
            String patr = wordList[2];

            if (!(Objects.equals(sur, name) || Objects.equals(sur, patr) || Objects.equals(name, patr))) {
                return "%s %c. %c.".formatted(name, sur.charAt(0), patr.charAt(0));
            }
        }
        else if (halfName.matcher(raw).matches()) {
            String sur = wordList[0];
            String name = wordList[1];
            if (!(Objects.equals(sur, name))) {
                return "%s %c.".formatted(name, sur.charAt(0));
            }
        }
        return "";
    }

    public static void read_file() {
        try {
            Scanner sc = new Scanner(new File("src/main/java/sgu/ru/input.txt"));
            while (sc.hasNextLine()) {
                System.out.println(parse_file(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
        }
    }
}
