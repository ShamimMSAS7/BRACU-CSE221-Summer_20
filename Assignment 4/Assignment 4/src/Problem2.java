
import java.util.Scanner;

public class Problem2 {

    static String club[];
    static int weight[];
    static double price[];
    static String trophy[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        int x = sc.nextInt();
        club = new String[x];
        weight = new int[x];
        price = new double[x];
        trophy = new String[x];
        sc.nextLine();
        for (int i = 0; i < x; i++) {
            String str = sc.nextLine();

            String[] string = str.split(", ");
            club[i] = string[0];
            price[i] = Double.parseDouble(string[2]);
            weight[i] = Integer.parseInt(string[1]);
            trophy[i] = string[3];

        }
        int count = 0;
        for (int i = 0; i < x; i++) {
            if (trophy[i].startsWith("Cham")) {
                count++;
            }
        }
        int cl[] = new int[count];
        double clPrice[] = new double[count];
        String result[] = new String[count];
        for (int i = 0, j = 0; i < trophy.length; i++) {
            if (trophy[i].startsWith("Cham")) {
                cl[j++] = i;
            }
        }
        for (int i = 0; i < count; i++) {
            double[][] matrix = new double[x + 1][budget + 1 - weight[cl[i]]];
            knapsack(matrix, cl[i]);
            String str = backtrack(matrix, cl[i]);
            result[i] = str.substring(0, str.length() - 2);

            clPrice[i] = matrix[x][matrix[x].length - 1] + price[cl[i]];

        }
        int max = 0;
        for (int i = 1; i < count; i++) {
            if (clPrice[i] > clPrice[max]) {
                max = i;
            }

        }
        System.out.println(result[max]);
        System.out.println(clPrice[max]);
    }

    static void knapsack(double[][] array, int n) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;

                } else if (i == n + 1 || j < weight[i - 1]) {
                    array[i][j] = array[i - 1][j];

                } else {
                    array[i][j] = max(array[i - 1][j], array[i - 1][j - weight[i - 1]] + price[i - 1]);
                }
            }
        }
    }

    static double max(double x, double y) {
        if (y > x) {
            return y;
        }
        return x;
    }

    static String backtrack(double[][] array, int n) {
        int i = array.length - 1;
        int j = array[0].length - 1;
        String str = "";
        while (j > 0 && i > 0) {
            if (i == n + 1) {
                str = club[i - 1] + "->" + str;
            }
            if (array[i][j] != array[i - 1][j]) {
                str = club[i - 1] + "->" + str;
                j = j - weight[i - 1];
            }
            i--;
        }
        return str;
    }
}
