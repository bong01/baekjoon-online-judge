package boj_2908_상수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        StringBuffer firstString = new StringBuffer(st.nextToken()).reverse();
        int firstNum = Integer.parseInt(firstString.toString());

        StringBuffer secondString = new StringBuffer(st.nextToken()).reverse();
        int secondNum = Integer.parseInt(secondString.toString());

        System.out.println(Math.max(firstNum, secondNum));
    }
}
