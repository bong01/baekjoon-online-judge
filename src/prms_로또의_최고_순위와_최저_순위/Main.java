package prms_로또의_최고_순위와_최저_순위;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0;
        int sameCnt = 0;

        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zeroCnt++;
            } else {
                int idx = i;
                boolean b = IntStream.of(win_nums).anyMatch(e -> e == lottos[idx]);
                if (b) sameCnt++;
            }
        }

        answer[0] = Math.min(7 - sameCnt - zeroCnt, 6);
        answer[1] = Math.min(7 - sameCnt, 6);

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] lottos = new int[6];
        int[] win_nums = new int[6];

        for (int i = 0; i < 6; i++) {
            lottos[i] = sc.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            win_nums[i] = sc.nextInt();
        }

        int[] answer = solution(lottos, win_nums);
        System.out.println(answer[0] + ", " + answer[1]);
    }
}
