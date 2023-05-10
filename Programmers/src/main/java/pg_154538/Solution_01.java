package pg_154538;

import java.util.*;

//  숫자 변환하기
//  https://school.programmers.co.kr/learn/courses/30/lessons/154538
public class Solution_01 {
    public static List<Integer> list;
    public static int goalNum;
    public static int addNum;

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }

    public static int solution(int x, int y, int n) {
        list = new ArrayList<>();

        goalNum = y;
        addNum = n;

        bfs( x, 0);

        if (list.isEmpty()) {
            return -1;
        }

        return list.stream().mapToInt(i -> i).filter(i -> i > 0).min().getAsInt();
    }

    public static void bfs(int x, int count) {
        if (x == goalNum) {
            list.add(count);
            return;
        }

        if (x > goalNum) {
            return;
        }

        if (x > 1000000) {
            return;
        }

        if (x + addNum <= goalNum) {
            bfs(x+addNum, count+1);
        }

        if (x * 2 <= goalNum) {
            bfs(x*2, count+1);
        }

        if (x * 3 <= goalNum) {
            bfs(x*3, count+1);
        }
    }
}
