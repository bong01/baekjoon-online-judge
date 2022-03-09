package boj_1157_단어_공부;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().toUpperCase();

        Map<Character, Integer> frequency = new HashMap<>();

        for (int i = 0; i < line.length(); i++) {
            char alphabet = line.charAt(i);
            if (frequency.containsKey(alphabet)) {
                frequency.put(alphabet, frequency.get(alphabet) + 1);
            } else {
                frequency.put(alphabet, 1);
            }
        }

        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(frequency.entrySet());
        entryList.sort(Map.Entry.comparingByValue());
        if (entryList.size() > 1 && entryList.get(entryList.size() - 1).getValue().equals(entryList.get(entryList.size() - 2).getValue())) {
            System.out.println("?");
        } else {
            System.out.println(entryList.get(entryList.size() - 1).getKey());
        }
    }
}
