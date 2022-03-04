package boj_2309_일곱_난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();

        loop:
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (sum - list.get(i) - list.get(j) == 100) {
                    Set<Integer> notDwarf = new HashSet<>();
                    notDwarf.add(list.get(i));
                    notDwarf.add(list.get(j));
                    list.stream().filter(n -> !notDwarf.contains(n)).sorted().forEach(System.out::println);
                    break loop;
                }
            }
        }

    }
}
