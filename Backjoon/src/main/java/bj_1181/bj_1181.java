package bj_1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class bj_1181 {
    public static void main(String[] args) throws IOException {
        List<String> strList = new ArrayList<>();
        List<String> resList = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            strList.add(br.readLine());
        }

        for (String s :
                strList) {
            if (s.matches("[0-9]*")) {
                continue;
            }

            if (resList.contains(s)) {
                continue;
            }

            resList.add(s);
        }

        Collections.sort(resList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                } else {
                    if (o1.length() < o2.length()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        });

        for (String s :
                resList) {
            System.out.println(s);
        }
    }
}
