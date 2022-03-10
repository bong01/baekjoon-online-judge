package boj_2941_크로아티아_알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String newLine = line.replace("dz=", "a")
                .replace("dz-", "a")
                .replace("lj", "a")
                .replace("nj", "a")
                .replace("=", "")
                .replace("-", "");
        System.out.println(newLine.length());
    }
}
