import java.util.*;

public class Solution {
    //  https://school.programmers.co.kr/learn/courses/30/lessons/43105

    public static void main(String[] args) {
        System.out.println(new Solution().solution(new int[][]{
                {1},
                {1, 1},
                {1, 1, 1},
                {1, 1, 0, 1,},
                {1, 1, 1, 1, 1}
        }));
    }
    static int[][] table;

    public int solution(int[][] triangle) {
        //  일단 그리디는 X

        table = new int[triangle.length][triangle.length];
        table[0][0] = triangle[0][0];
        if (triangle.length == 1) {
            return table[0][0];
        }

        dp(triangle, 0, 0, table[0][0]);

        System.out.println(Arrays.deepToString(table));

        return Arrays.stream(table[table.length - 1]).max().getAsInt();
    }

    public void dp(int[][] triangle, int idx, int depth, int sum) {
        if (table[depth][idx] == 0) {
            table[depth][idx] = sum + triangle[depth][idx];
        }

        if (depth == triangle.length - 1) {
            if (table[depth][idx] != 0) {
                table[depth][idx] = Math.max(table[depth][idx], sum + triangle[depth][idx]);
            }
            return;
        }

        dp(triangle, idx, depth+1, table[depth][idx]);
        dp(triangle, idx+1, depth+1, table[depth][idx]);
    }
}
