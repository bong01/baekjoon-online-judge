package boj_2292_벌집;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int i = 0;
        int sum = 1;
        while (true) {
            sum += 6 * i;
            if (sum >= n) {
                System.out.println(i + 1);
                break;
            }
            i++;
        }
    }
}
