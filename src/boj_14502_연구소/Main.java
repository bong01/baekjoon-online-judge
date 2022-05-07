package boj_14502_연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int n, m, result = 0;
    //지도
    static int[][] map = new int[8][8];
    //복사를 위한 배열
    static int[][] temp = new int[8][8];

    static int SPACE = 0;
    static int WALL = 1;
    static int VIRUS = 2;


    //방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

    public static void spreadVirus(int x, int y) {
        //방향마다
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                //빈 칸이라면 바이러스 전파
                if (temp[nx][ny] == SPACE) {
                    temp[nx][ny] = VIRUS;
                    //재귀적으로(DFS)
                    spreadVirus(nx, ny);
                }
            }
        }
    }

    //안전 영역 카운트
    public static int countSpace() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (temp[i][j] == SPACE) {
                    count += 1;
                }
            }
        }
        return count;
    }

    //DFS로 벽을 설치하면서 매 번 안전 영역 계산
    public static void dfs(int count) {
        //벽 3개를 다 세웠을 경우
        if (count == 3) {
            //지도 복사
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    temp[i][j] = map[i][j];
                }
            }
            //바이러스 전파
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (temp[i][j] == 2) {
                        spreadVirus(i, j);
                    }
                }
            }

            //최대 안전 영역 계산
            result = Math.max(result, countSpace());
            return;
        }

        //벽 3개를 아직 못 채웠을 경우
        //빈 칸이면 벽 설치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == SPACE) {
                    map[i][j] = WALL;
                    count += 1;
                    dfs(count);
                    map[i][j] = SPACE;
                    count -= 1;
                }
            }
        }
    }

}