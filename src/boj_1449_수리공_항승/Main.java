package boj_1449_수리공_항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int count = 0;
        int length = 1;

        for (int i = 0; i < n - 1; i++) {
            length += list.get(i + 1) - list.get(i);
            if (length > l) {
                count++;
                length = 1;
            }
        }

        System.out.println(count + 1);
    }
}
