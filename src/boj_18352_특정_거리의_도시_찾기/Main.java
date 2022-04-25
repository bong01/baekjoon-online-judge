package boj_18352_특정_거리의_도시_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //도시의 개수
        int n = Integer.parseInt(st.nextToken());
        //도로의 개수
        int m = Integer.parseInt(st.nextToken());
        //거리 정보
        int k = Integer.parseInt(st.nextToken());
        //출발 도시의 번호
        int x = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        int[] d = new int[n + 1];

        //초기화
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
            d[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }

        //시작 도시
        d[x] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            //현재 도시에서 이동할 수 있는 도시 탐색
            for (int i = 0; i < graph.get(now).size(); i++) {
                int next = graph.get(now).get(i);
                //아직 방문하지 않은 도시인 경우 최단 거리 갱신
                if (d[next] == -1) {
                    d[next] = d[now] + 1;
                    queue.add(next);
                }
            }
        }

        //최단 거리가 k인 도시 오름차순으로 출력
        boolean isPresent = false;
        for (int i = 0; i < n + 1; i++) {
            if (d[i] == k) {
                System.out.println(i);
                isPresent = true;
            }
        }

        //최단 거리가 k인 도시가 없을 경우
        if (!isPresent) {
            System.out.println(-1);
        }

    }

}
