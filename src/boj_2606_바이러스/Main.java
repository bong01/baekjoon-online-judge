package boj_2606_바이러스;

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
                    answer++;
                    dfs(j);
                }
            }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 컴퓨터 수
        int c = sc.nextInt(); // 연결 수
        arr = new int[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < c; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(1);

        System.out.println(answer);
    }
}
