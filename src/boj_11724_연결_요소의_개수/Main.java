package boj_11724_연결_요소의_개수;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visit;
    static int answer;

    public static void dfs(int i) {
        visit[i] = true;

        for (int j = 1; j <= n; j++) {
            if (arr[i][j] == 1 && !visit[j]) {
                dfs(j);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            arr[u][v] = arr[v][u] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
    }
}
