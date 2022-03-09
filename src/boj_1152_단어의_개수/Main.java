package boj_1152_단어의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] word = br.readLine().trim().split(" ");
        if (word[0].equals("")) {
            System.out.println(0);
        } else {
            System.out.println(word.length);
        }
    }
}
