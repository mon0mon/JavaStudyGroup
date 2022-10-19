package pg_42747;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] citations = {
                {3, 1, 1, 1, 4},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1},
                {9, 9, 9, 12},
                {1, 1, 5, 7, 6}
        };

        for (int[] item :
                citations) {
            System.out.println(solution(item));
        }
    }

    //테스트 1 〉	통과 (16.31ms, 78.2MB)
    //테스트 2 〉	통과 (20.33ms, 83.4MB)
    //테스트 3 〉	통과 (17.68ms, 82.3MB)
    //테스트 4 〉	통과 (18.06ms, 87.1MB)
    //테스트 5 〉	통과 (14.87ms, 74.9MB)
    //테스트 6 〉	통과 (16.51ms, 84.4MB)
    //테스트 7 〉	통과 (13.04ms, 79.6MB)
    //테스트 8 〉	통과 (1.36ms, 83.4MB)
    //테스트 9 〉	실패 (5.61ms, 75.5MB)
    //테스트 10 〉	통과 (14.53ms, 89.3MB)
    //테스트 11 〉	통과 (17.09ms, 77.7MB)
    //테스트 12 〉	통과 (6.52ms, 80MB)
    //테스트 13 〉	통과 (32.78ms, 92.1MB)
    //테스트 14 〉	통과 (38.74ms, 85.1MB)
    //테스트 15 〉	통과 (18.03ms, 65.2MB)
    //테스트 16 〉	통과 (0.67ms, 73.4MB)
    public static int solution(int[] numbers) {
        List<Integer> intList = new ArrayList<>();

        for (int num :
                numbers) {
            intList.add(num);
        }

        intList.sort((Integer i1, Integer i2) -> i1.compareTo(i2));

        int hIdx = 0;

        //  [0, 1, 3, 5, 6]
        for (int i = 0; i < intList.size(); i++) {
            int overCitation = 0;
            int lessCitation = 0;

            for (int j = 0; j < intList.size(); j++) {
                if (intList.get(j) >= i) {
                    overCitation++;
                } else {
                    lessCitation++;
                }
            }

//            System.out.println("overCitation : " + overCitation + " lessCitation : "
//                    + lessCitation + " index : " + i + " value : " + intList.get(i));

            if (overCitation >= i && lessCitation <= i && lessCitation > 0) {
                hIdx = i;
            }
        }

        return hIdx;
    }
}
