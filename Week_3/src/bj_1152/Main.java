package bj_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//  2022-09-21
//  https://www.acmicpc.net/problem/1152
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] strSplitAry = str.split(" ");
        int wordCount = 0;

        for (String item : strSplitAry) {
            if (!"".equals(item)) {
                wordCount++;
            }
        }

        System.out.println(wordCount);
    }
}
