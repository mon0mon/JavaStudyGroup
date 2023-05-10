package bj_2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalPersonCount = Integer.parseInt(br.readLine());
        String problem = br.readLine();

        int inputLineNum = Integer.parseInt(br.readLine());
        List<String> relation = new ArrayList<>();

        for (int i = 0; i < inputLineNum; i++) {
            relation.add(br.readLine());
        }
        br.close();

        Map<Integer, List<Integer>> inlistPerson = new HashMap<>();
        for (int i = 0; i < relation.size(); i++) {
            String[] split = relation.get(i).split(" ");
            int parent = Integer.parseInt(split[0]);
            int child = Integer.parseInt(split[1]);

            if (inlistPerson.keySet().contains(parent)) {
                List<Integer> list = inlistPerson.get(parent);
            }
        }
    }
}
