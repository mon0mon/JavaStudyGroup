package pg_154538;

import java.util.*;

//  숫자 변환하기
//  https://school.programmers.co.kr/learn/courses/30/lessons/154538
public class Solution_02 {
    public static Queue<Node> queue;
    public static int goalNum;
    public static int addNum;

    public static void main(String[] args) {
        System.out.println(solution(10, 40, 5));
        System.out.println(solution(10, 40, 30));
        System.out.println(solution(2, 5, 4));
    }

    public static int solution(int x, int y, int n) {
        queue = new ArrayDeque<Node>();
        boolean[] map = new boolean[3000000 + 1];

        goalNum = y;
        addNum = n;

        queue.add(new Node(x, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            queue.remove(node);

            if (node.x == goalNum) {
                return node.count;
            }

            if (node.x > goalNum) {
                continue;
            }

            if (node.x + addNum <= goalNum && !map[node.x + addNum]) {
                queue.add(new Node(node.x + addNum, node.count + 1));
                map[node.x + addNum] = true;
            }

            //  y가 2로 나누어질때만 계산하기
            if (node.x * 2 <= goalNum && !map[node.x * 2]) {
                queue.add(new Node(node.x * 2, node.count + 1));
                map[node.x * 2] = true;
            }

            //  y가 3으로 나누어질때만 계산하기
            if (node.x * 3 <= goalNum && !map[node.x * 3]) {
                queue.add(new Node(node.x * 3, node.count + 1));
                map[node.x * 3] = true;
            }
        }

        return -1;
    }
}

class Node {
    int x;
    int count;

    public Node(int x, int count) {
        this.x = x;
        this.count = count;
    }
}
