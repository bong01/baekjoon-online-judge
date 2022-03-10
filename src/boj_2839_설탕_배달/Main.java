package boj_2839_설탕_배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        if (n % 5 == 0) {
            result = n / 5;
        }
        if (n % 3 == 0) {
            result = n / 3;
        }
        int divNum = n / 5;
        for (int i = 0; i < n / 5; i++) {
            if ((n - (5 * divNum)) % 3 == 0) {
                result = divNum + (n - (5 * divNum)) / 3;
            } else {
                divNum--;
            }
        }

        if (result == 0) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}
