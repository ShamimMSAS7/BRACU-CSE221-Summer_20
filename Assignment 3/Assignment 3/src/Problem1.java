
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ShamimMSAS7
 */
public class Problem1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        String[] x = a.split(" ");
        String[] y = b.split(" ");
        int[][] matrix = new int[x.length + 1][y.length + 1];
        lcs(matrix, x, y);
        String str = seq(matrix, x, y);
        double acc = 1.0 * (matrix[x.length][y.length]) / x.length * 100;
        String result;
        if (acc >= 50) {
            result = "PASSED";
        } else {
            result = "FAILED";
        }
        System.out.println(str);
        System.out.println(acc + "% " + result);
    }

    static void lcs(int[][] z, String[] x, String[] y) {
        for (int i = 0; i < z.length; i++) {
            for (int j = 0; j < z[i].length; j++) {
                if (i == 0 || j == 0) {
                    z[i][j] = 0;
                } else if (x[i - 1].equals(y[j - 1])) {
                    z[i][j] = z[i - 1][j - 1] + 1;
                } else {
                    z[i][j] = max(z[i - 1][j], z[i][j - 1]);
                }
            }
        }
    }

    static int max(int x, int y) {
        if (x > y) {
            return x;
        }
        return y;
    }

    static String seq(int[][] z, String[] x, String[] y) {
        int i = x.length;
        int j = y.length;
        int k = z[i][j];
        String str = "";
        while (k > 0) {
            if (z[i][j] == z[i][j - 1]) {
                j--;
            } else if (z[i][j] == z[i - 1][j]) {
                i--;
            } else {
                str = x[i - 1] + str;
                i--;
                j--;
                k--;
            }
        }
        return str;
    }
}
