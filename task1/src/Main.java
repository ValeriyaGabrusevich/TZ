import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите аргументы");
        String arguments = scanner.nextLine();
        int n, m;
        String[] mas = arguments.split("\\s");
        n = Integer.parseInt(mas[0]);
        m = Integer.parseInt(mas[1]);
        if (n == 0 || m == 0) {
            System.out.println("Длина массива 0!");
        } else {
            double k = Math.ceil((double) m / n);
            int[] initialMas = new int[n];
            for (int i = 0; i < initialMas.length; i++) {
                initialMas[i] = i + 1;
            }
            int[] finalMas = new int[(int) (n * k)];
            for (int i = 0; i < k; i++) {
                System.arraycopy(initialMas, 0, finalMas, i * initialMas.length, initialMas.length);
            }
            ArrayList<Integer> ways = new ArrayList<>();
            ArrayList<Integer> newWays = findWays(1, finalMas, m, ways);
            for (Integer element : newWays) {
                System.out.print(element);
            }
        }
    }

    public static ArrayList<Integer> findWays(int k, int[] mas, int m, ArrayList<Integer> finalArray) {
        int neededElement = 1;
        int[] newMas = new int[k * mas.length];
        for (int i = 0; i < k; i++) {
            System.arraycopy(mas, 0, newMas, i * mas.length, mas.length);
        }
        int way = newMas[m * k - m - k + 1];
        if (newMas[(m - 1) * k] == neededElement) {
            finalArray.add(way);
        } else {
            finalArray.add(way);
            findWays(k + 1, mas, m, finalArray);
        }

        return finalArray;
    }
}