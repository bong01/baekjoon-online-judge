package boj_1149_RGB거리;

import java.util.Scanner;

public class Main {
    static int[][] arr;

    public static int solution(int n) {
        int answer;

        for (int i = 1; i < n; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][0], arr[i - 1][1]);
        }

        answer = Math.min(arr[n-1][0], arr[n-1][1]);
        answer = Math.min(answer, arr[n-1][2]);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
            arr[i][2] = sc.nextInt();
        }

        int answer = solution(n);
        System.out.println(answer);
    }
}
