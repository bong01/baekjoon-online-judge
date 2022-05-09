package boj_18428_감시_피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static char[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean canHide = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new char[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0);
        System.out.println(canHide ? "YES" : "NO");
    }

    static void dfs(int count) {
        //장애물 3개 설치 시
        if (count == 3) {
            int hideFromT = 0;
            int countT = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 'T') {
                        countT++;
                        if (!findStudent(i, j)) {
                            hideFromT++;
                        }
                    }
                }
            }
            if (hideFromT == countT) {
                canHide = true;
            }
        } else {
            //장애물이 아직 3개가 아닐 시 설치
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 'X') {
                        graph[i][j] = 'O';
                        count += 1;
                        dfs(count);
                        graph[i][j] = 'X';
                        count -= 1;
                    }
                }
            }
        }
    }

    static boolean findStudent(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            while (true) {
                nx += dx[i];
                ny += dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    break;
                }
                if (graph[nx][ny] == 'O') {
                    break;
                }
                if (graph[nx][ny] == 'S') {
                    return true;
                }
            }
        }
        return false;
    }
}
