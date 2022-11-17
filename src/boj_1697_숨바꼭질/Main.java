package boj_1697_숨바꼭질;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Node {
        public int x;
        public int depth;

        public Node(int x, int depth) {
            this.x = x;
            this.depth = depth;
        }
    }

    static boolean[] visit = new boolean[100001];
    static int k;

    public static void bfs(int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x - 1, 1));
        q.add(new Node(x + 1, 1));
        q.add(new Node(x * 2, 1));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x >= 0 && node.x <= 100000 && !visit[node.x]) {
                if (node.x == k) {
                    System.out.println(node.depth);
                    break;
                }
                visit[node.x] = true;
                q.add(new Node(node.x - 1, node.depth + 1));
                q.add(new Node(node.x + 1, node.depth + 1));
                q.add(new Node(node.x * 2, node.depth + 1));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        if (n == k) System.out.println(0);
        else bfs(n);
    }
}
