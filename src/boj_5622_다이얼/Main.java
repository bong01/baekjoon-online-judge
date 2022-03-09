package boj_5622_다이얼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        while (true) {
            int dial = br.read();
            if (dial == '\n') {
                break;
            }
            if (dial < 68) {
                result += 3;
            } else if (dial < 71) {
                result += 4;
            } else if (dial < 74) {
                result += 5;
            } else if (dial < 77) {
                result += 6;
            } else if (dial < 80) {
                result += 7;
            } else if (dial < 84) {
                result += 8;
            } else if (dial < 87) {
                result += 9;
            } else if (dial < 91) {
                result += 10;
            }
        }

        System.out.println(result);
    }
}
