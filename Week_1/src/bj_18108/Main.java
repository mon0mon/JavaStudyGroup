package bj_18108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int buddaYear = Integer.parseInt(br.readLine());

        int christYear = buddaYear - 543;

        System.out.println(christYear);
    }
}
