package boj_1316_그룹_단어_체커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isGroupWord = true;
            String line = br.readLine();
            List<Character> charList = new ArrayList<>();
            charList.add(line.charAt(0));

            for (int j = 1; j < line.length(); j++) {
                if (line.charAt(j - 1) != line.charAt(j) && charList.contains(line.charAt(j))) {
                    isGroupWord = false;
                    break;
                }

                charList.add(line.charAt(j));
            }
            if (isGroupWord){
                count++;
            }
        }

        System.out.println(count);
    }
}
