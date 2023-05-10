package pg_42840;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] answer = {1, 3, 2, 4, 2};

        solution(answer);
    }

    //테스트 1 〉	실패 (10.62ms, 75.2MB)
    //테스트 2 〉	실패 (9.19ms, 78MB)
    //테스트 3 〉	통과 (8.25ms, 74.4MB)
    //테스트 4 〉	통과 (7.60ms, 76.9MB)
    //테스트 5 〉	실패 (6.20ms, 79.2MB)
    //테스트 6 〉	실패 (6.76ms, 73.6MB)
    //테스트 7 〉	실패 (7.27ms, 73.3MB)
    //테스트 8 〉	실패 (7.62ms, 74.1MB)
    //테스트 9 〉	실패 (9.74ms, 81.3MB)
    //테스트 10 〉	실패 (6.98ms, 72.2MB)
    //테스트 11 〉	실패 (8.52ms, 84.5MB)
    //테스트 12 〉	실패 (7.69ms, 76.6MB)
    //테스트 13 〉	통과 (6.94ms, 72.7MB)
    //테스트 14 〉	실패 (7.97ms, 76.4MB)
    //채점 결과
    //정확성: 21.4
    //합계: 21.4 / 100.0
    public static int[] solution(int[] answers) {
        final int totalPersonCount = 3;
        int[] rank;
        int[] res;
        List<Integer> exclude = new ArrayList<>();
        List<Integer> resAry = new ArrayList<>();

        rank = getAnswerCount(answers);

        for (int i = 0; i < totalPersonCount; i++) {
            int max = 0;
            int mostCorrectPerson = 0;
            for (int j = 0; j < totalPersonCount; j++) {
                if (exclude.contains(j)) {
                    continue;
                }

                if (max < rank[j]) {
                    max = rank[j];
                    mostCorrectPerson = j + 1;
                    exclude.add(j);
                }
            }

            if (mostCorrectPerson == 0) {
                break;
            }

            resAry.add(mostCorrectPerson);
        }

        res = new int[resAry.size()];
        for (int i = 0; i < resAry.size(); i++) {
            res[i] = resAry.get(i);
        }

        return res;
    }

    public static int[] getAnswerCount(int[] problem) {
        int[] person1st = {1, 2, 3, 4, 5};
        int[] person2nd = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] person3rd = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] res = new int[3];

        for (int i = 1; i <= 3; i++) {
            switch (i) {
                case 1:
                    res[0] = matchCount(problem, person1st);
                    break;
                case 2:
                    res[1] = matchCount(problem, person2nd);
                    break;
                default:
                    res[2] = matchCount(problem, person3rd);
                    break;
            }
        }

        return res;
    }

    public static int matchCount(int[] problem, int[] answer) {
        int j = 0;
        int count = 0;

        for (int i = 0; i < problem.length; i++) {
            if (j >= answer.length) {
                j = 0;
            }

            if (problem[i] == answer[j]) {
                count++;
            }

            j++;
        }

        if (count == 0) {
            return -1;
        } else {
            return count;
        }
    }
}
