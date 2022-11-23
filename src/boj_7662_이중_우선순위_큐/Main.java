package boj_7662_이중_우선순위_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int i = 0; i < t; i++) {
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            int k = Integer.parseInt(br.readLine()); // 연산 개수

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                String op = input[0]; // 연산 (Delete, Insert)
                int n = Integer.parseInt(input[1]); // 피연산자

                if (op.equals("I")) {
                    tm.put(n, tm.getOrDefault(n, 0) + 1);
                } else  if (op.equals("D") && !tm.isEmpty()){
                    if (n == 1) {
                        if (tm.get(tm.lastKey()) > 1) tm.replace(tm.lastKey(), tm.get(tm.lastKey()) - 1);
                        else tm.remove(tm.lastKey());
                    } else {
                        if (tm.get(tm.firstKey()) > 1) tm.replace(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                        else tm.remove(tm.firstKey());
                    }
                }
            }

            if (tm.isEmpty()) sb.append("EMPTY").append("\n");
            else sb.append(tm.lastKey()).append(" ").append(tm.firstKey()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
