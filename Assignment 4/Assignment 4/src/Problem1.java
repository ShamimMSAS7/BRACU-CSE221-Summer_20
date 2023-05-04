
import java.util.Scanner;

public class Problem1 {

    static String player[];
    static int price[];
    static int form[];
    static char position[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int budget = sc.nextInt();
        int x = sc.nextInt();
        player = new String[x];
        price = new int[x];
        form = new int[x];
        position = new char[x];
        for (int i = 0; i < x; i++) {
            String str;
            str = sc.next();
            player[i] = str.substring(0, str.length() - 1);
            str = sc.next();
            str = str.substring(0, str.length() - 1);
            price[i] = Integer.parseInt(str);
            str = sc.next();
            str = str.substring(0, str.length() - 1);
            form[i] = Integer.parseInt(str);
            str = sc.next();
            position[i] = str.charAt(0);
        }

        int[][] matrix = new int[x + 1][budget + 1];
        knapsack(matrix);
        String str = backtrack(matrix);
        System.out.println(str.substring(0, str.length() - 2));
        System.out.println(matrix[x][budget]);
    }

    static void knapsack(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == 0 || j == 0) {
                    array[i][j] = 0;
                } else if (j < price[i - 1]) {
                    array[i][j] = array[i - 1][j];
                } else {
                    array[i][j] = max(array[i - 1][j], array[i - 1][j - price[i - 1]] + form[i - 1]);
                }
            }
        }
    }

    static int max(int x, int y) {
        if (y > x) {
            return y;
        }
        return x;
    }

    static String backtrack(int[][] array) {
        int i = array.length - 1;
        int j = array[0].length - 1;
        String str = "";
        while (j > 0 && i > 0) {
            if (array[i][j] != array[i - 1][j]) {
                str = player[i - 1] + "->" + str;
                j = j - price[i - 1];
            }
            i--;
        }
        return str;
    }
}
