package boj_16234_인구_이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, l, r;
    static int[][] graph;
    static boolean[][] visited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static ArrayList<Node> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(move());

    }

    static int move() {
        int result = 0;

        //더 이상 인구 이동이 일어나지 않을 때까지 반복
        while (true) {
            boolean isMove = false;
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j]) {
                        //BFS로 열릴 수 있는 국경선을 확인하고 이동할 인구 수 반환
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            //국경선이 열린 나라들의 인구 수 변경
                            changePopulation(sum);
                            isMove = true;
                        }
                    }
                }
            }
            if (!isMove) {
                return result;
            }
            result++;
        }

    }


    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        list = new ArrayList<>();

        q.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = graph[x][y];

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny]) {
                    int diff = Math.abs(graph[current.x][current.y] - graph[nx][ny]);
                    if (l <= diff && diff <= r) {
                        q.offer(new Node(nx, ny));
                        list.add(new Node(nx, ny));
                        sum += graph[nx][ny];
                        visited[nx][ny] = true;
                    }
                }
            }

        }

        return sum;
    }

    public static void changePopulation(int sum) {
        int avg = sum / list.size();
        for (Node n : list) {
            graph[n.x][n.y] = avg;
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
