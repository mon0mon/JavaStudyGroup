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

    //  바보 이건 dfs..
    //  bfs는 queue를 사용한게 bfs
    //  재귀나 stack을 사용한게 dfs

    //  추가적으로 x*2와 x*3의 연산이 겹치는 부분이 있을텐데, 이 때 메모이제이션을 써서 값을 확인하면 실행시간 단축 가능
    //  다만 이걸로 통과되는 코드인지는 불확실

    //  dfs말고 bfs로 풀기
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
