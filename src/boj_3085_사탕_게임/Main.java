package boj_3085_사탕_게임;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[][] arr = new String[n][n];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = String.valueOf(line.charAt(j));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n && !arr[i][j].equals(arr[i][j + 1])) {
                    list.add(countCandy(swap(arr, new int[]{i, j}, new int[]{i, j + 1})));
                    swap(arr, new int[]{i, j}, new int[]{i, j + 1});
                }
                if (i + 1 < n && !arr[i][j].equals(arr[i + 1][j])) {
                    list.add(countCandy(swap(arr, new int[]{i, j}, new int[]{i + 1, j})));
                    swap(arr, new int[]{i, j}, new int[]{i + 1, j});
                }
            }
        }
        System.out.println(Collections.max(list));
    }

    static int countCandy(String[][] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            String str = "";
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals(str)) {
                    count++;
                    list.add(count);
                } else {
                    count = 1;
                    str = arr[i][j];
                }
            }
        }

        for (int j = 0; j < arr.length; j++) {
            int count = 1;
            String str = "";
            for (int i = 0; i < arr[j].length; i++) {
                if (arr[i][j].equals(str)) {
                    count++;
                    list.add(count);
                } else {
                    count = 1;
                    str = arr[i][j];
                }
            }
        }
        return Collections.max(list);
    }

    static String[][] swap(String[][] arr, int[] a, int[] b) {
        String temp = arr[a[0]][a[1]];
        arr[a[0]][a[1]] = arr[b[0]][b[1]];
        arr[b[0]][b[1]] = temp;
        return arr;
    }
}
