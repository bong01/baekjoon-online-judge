package boj_14888_연산자_끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Integer> nums = new ArrayList<>();
    static int add, sub, mul, div;
    static int min = (int) 1e9;
    static int max = (int) -1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //n개의 수
        n = Integer.parseInt(br.readLine());

        for (StringTokenizer st = new StringTokenizer(br.readLine()); st.hasMoreTokens(); ) {
            nums.add(Integer.parseInt(st.nextToken()));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        dfs(1, nums.get(0));

        System.out.println(max);
        System.out.println(min);
    }

    //i: 몇 번째 수, now: 현재 계산된 값
    static void dfs(int i, int now) {
        if (i == n) {
            min = Math.min(min, now);
            max = Math.max(max, now);
        } else {
            if (add > 0) {
                add--;
                dfs(i + 1, now + nums.get(i));
                add++;
            }
            if (sub > 0) {
                sub--;
                dfs(i + 1, now - nums.get(i));
                sub++;
            }
            if (mul > 0) {
                mul--;
                dfs(i + 1, now * nums.get(i));
                mul++;
            }
            if (div > 0) {
                div--;
                dfs(i + 1, now / nums.get(i));
                div++;
            }
        }
    }

}
