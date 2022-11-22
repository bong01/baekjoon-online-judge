package boj_2630_색종이_만들기;

import java.util.Scanner;

public class Main {
    static int[][] arr;
    static int blue, white;

    public static void divide(int x, int y, int n) {
        if (n == 1 || isSameColor(x, y, n)) {
            if (arr[x][y] == 1) blue++;
            else white++;
            return;
        }

        int half = n / 2;

        divide(x, y, half);
        divide(x, y + half, half);
        divide(x + half, y, half);
        divide(x + half, y + half, half);
    }

    public static boolean isSameColor(int x, int y, int n) {
        int color = arr[x][y];

        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[i][j] != color) return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, n);

        System.out.println(white);
        System.out.println(blue);
    }
}
