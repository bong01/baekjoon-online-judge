package boj_1260_DFS와_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int n;
    static int[][] arr;
    static boolean[] visit;

    public static void dfs(int v) {
        visit[v] = true;
        System.out.print(v + " ");

        for (int i = 1; i <= n; i++) {
            if (arr[v][i] == 1 && !visit[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visit[v] = true;

        while (!q.isEmpty()) {
            int e = q.poll();
            System.out.print(e + " ");

            for (int i = 1; i <= n; i++) {
                if (arr[e][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(v);

        visit = new boolean[n + 1];
        System.out.println();

        bfs(v);
    }
}
