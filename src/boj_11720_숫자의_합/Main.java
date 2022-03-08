package boj_11720_숫자의_합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String nums = br.readLine();

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += Character.getNumericValue(nums.charAt(i));
        }

        System.out.println(sum);
    }
}
