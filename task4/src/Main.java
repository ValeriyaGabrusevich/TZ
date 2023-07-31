import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла:");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        ArrayList<String> files = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                files.add(line);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        if (files.isEmpty()) {
            return;
        }
        ArrayList<Integer> finalValues = new ArrayList<>();
        for (String element : files) {
            finalValues.add(getValue(element));
        }

        int median;
        int sum = 0;
        Collections.sort(finalValues);
        int arrayHalf = finalValues.size() / 2;
        if (finalValues.size() % 2 == 0) {
            median = (finalValues.get(arrayHalf) + finalValues.get(arrayHalf - 1)) / 2;
        } else {
            median = finalValues.get(arrayHalf);
        }

        for (int i = 0; i < finalValues.size(); i++) {
            sum += Math.abs(finalValues.get(i) - median);
        }
        System.out.println(sum);
    }

    public static int getValue(String input) {
        String[] numberString = input.split("\\s");
        int x;
        x = Integer.parseInt(numberString[0]);

        return x;
    }
}