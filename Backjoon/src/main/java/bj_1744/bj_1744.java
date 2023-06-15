package bj_1744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//  수 묶기
//  https://www.acmicpc.net/problem/1744

//  -1 0 일때 케이스
//  -1 -1 일때 케이스
//  1 1 1 일때 케이스
public class bj_1744 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

    public static int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ary = new int[Integer.parseInt(br.readLine())];

        for (int i = 0; i < ary.length; i++) {
            ary[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ary);

        int i, j;
        int mul = 1;
        int sum = 0;
        //  1이상인 값들을 대상으로 최대값을 구해서 sum에 저장
        for (j = ary.length-1; j >= 0; j--) {
            if (ary[j] <= 1) {
                break;
            }

            mul *= ary[j];
            if (mul == ary[j]) {
                continue;
            }
            sum += mul;
            mul = 1;
        }
        if (mul != 1) {
            sum += mul;
        }

        mul = 1;
        //  1 이하인 값들을 대상으로 최대값을 구해서 sum에 저장
        for (i = 0; i < j; i++) {
            if (ary[i] >= 1) {
                break;
            }

            mul *= ary[i];
            if (mul == ary[i]){
                continue;
            }
            sum += mul;
            mul = 1;
        }

        if (mul != 1) {
            sum += mul;
        }

        //  나머지 값들을 전부 더해서 sum에 저장
        for (int k = i; k <= j; k++) {
            sum += ary[k];
        }

        return sum;
    }
}
