package boj_11047_동전_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> coinList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coinList.add(Integer.valueOf(br.readLine()));
        }

        int count = 0;
        for (int coin : coinList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            if (coin <= k) {
                count += k / coin;
                k %= coin;
            }
        }

        System.out.println(count);
    }
}
