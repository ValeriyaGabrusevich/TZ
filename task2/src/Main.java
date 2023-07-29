import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла с координатами центра окружности и ее радиусом:");
        String fileName = scanner.nextLine();
        File circleFile = new File(fileName);

        System.out.println("Введите имя файла с координатами точек:");
        String fileName1 = scanner.nextLine();
        File pointFile = new File(fileName1);

        List<String> lines = getValuesFromFile(circleFile);

        PointF circlePoint = getPoint(lines.get(0));
        float radius = Float.parseFloat(lines.get(1));

        List<String> points = getValuesFromFile(pointFile);

        if (points.isEmpty() || points.size() > 100) {
            return;
        }

        ArrayList<PointF> finalPoints = new ArrayList<>();
        for (String element : points) {
            finalPoints.add(getPoint(element));
        }

        for (PointF pointF : finalPoints) {
            float hypotenuse = (float) Math.sqrt(Math.pow(circlePoint.getX() - pointF.getX(), 2) + Math.pow(circlePoint.getY() - pointF.getY(), 2));
            if (hypotenuse == radius) {
                System.out.println(0);
            } else if (hypotenuse < radius) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }

    public static ArrayList<String> getValuesFromFile(File file) {
        ArrayList<String> items = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
        return items;
    }

    public static PointF getPoint(String input) {
        String[] numberString = input.split("\\s");
        float x, y;
        x = Float.parseFloat(numberString[0]);
        y = Float.parseFloat(numberString[1]);
        return new PointF(x, y);
    }
}