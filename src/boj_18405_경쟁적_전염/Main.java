package boj_18405_경쟁적_전염;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, k, s, x, y;

    static int[][] graph = new int[200][200];
    static List<Virus> virusList = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //시험관 크기
        n = Integer.parseInt(st.nextToken());
        //바이러스 종류
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                //바이러스라면 리스트에 저장
                if (graph[i][j] != 0) {
                    virusList.add(new Virus(graph[i][j], 0, i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        //s초 후의 (x, y) 위치의 바이러스 확인
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        //바이러스 번호 순으로 정렬 후 큐에 삽입
        Collections.sort(virusList);
        Queue<Virus> q = new LinkedList<>(virusList);

        //BFS
        while (!q.isEmpty()) {
            Virus virus = q.poll();
            if (virus.sec == s) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                    //바이러스가 없으면 채우고 큐에 삽입
                    if (graph[nx][ny] == 0) {
                        graph[nx][ny] = virus.type;
                        q.add(new Virus(virus.type, virus.sec + 1, nx, ny));
                    }
                }
            }
        }
        System.out.println(graph[x - 1][y - 1]);
    }

    static class Virus implements Comparable<Virus> {
        int type;
        int sec;
        int x;
        int y;

        public Virus(int type, int sec, int x, int y) {
            this.type = type;
            this.sec = sec;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Virus o) {
            return type - o.type;
        }
    }

}
