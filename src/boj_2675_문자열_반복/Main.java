package boj_2675_문자열_반복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        List<StringBuilder> newStrList = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            StringBuilder newStr = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < r; k++) {
                    newStr.append(str.charAt(j));
                }
            }

            newStrList.add(newStr);
        }

        for (StringBuilder newStr : newStrList) {
            System.out.println(newStr);
        }

    }
}
