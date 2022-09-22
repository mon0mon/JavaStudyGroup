package pg_60057;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("ababcdcdababcdcd"));
    }

    //테스트 1 〉	통과 (8.67ms, 87.8MB)
    //테스트 2 〉	통과 (9.25ms, 79.2MB)
    //테스트 3 〉	통과 (9.43ms, 82.9MB)
    //테스트 4 〉	통과 (9.67ms, 76.1MB)
    //테스트 5 〉	실패 (0.02ms, 72.1MB)
    //테스트 6 〉	통과 (9.25ms, 66.7MB)
    //테스트 7 〉	통과 (10.96ms, 77.8MB)
    //테스트 8 〉	통과 (9.43ms, 78.1MB)
    //테스트 9 〉	통과 (10.11ms, 80.4MB)
    //테스트 10 〉	통과 (14.17ms, 84.1MB)
    //테스트 11 〉	통과 (12.69ms, 79.1MB)
    //테스트 12 〉	통과 (11.36ms, 78.9MB)
    //테스트 13 〉	통과 (10.79ms, 92.4MB)
    //테스트 14 〉	통과 (9.75ms, 78.4MB)
    //테스트 15 〉	통과 (9.15ms, 78.1MB)
    //테스트 16 〉	통과 (0.04ms, 74.9MB)
    //테스트 17 〉	통과 (11.61ms, 78.5MB)
    //테스트 18 〉	통과 (12.17ms, 77.8MB)
    //테스트 19 〉	통과 (11.82ms, 81.8MB)
    //테스트 20 〉	통과 (12.15ms, 77.1MB)
    //테스트 21 〉	통과 (14.87ms, 77.6MB)
    //테스트 22 〉	통과 (15.04ms, 82.1MB)
    //테스트 23 〉	통과 (17.86ms, 92.1MB)
    //테스트 24 〉	통과 (11.65ms, 76.2MB)
    //테스트 25 〉	통과 (14.16ms, 82.4MB)
    //테스트 26 〉	통과 (13.45ms, 81.6MB)
    //테스트 27 〉	통과 (16.54ms, 83MB)
    //테스트 28 〉	통과 (14.27ms, 77.4MB)
    //채점 결과
    //정확성: 96.0
    //합계: 96.0 / 100.0
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int splitSize = 1;

        while (splitSize <= s.length() / 2) {
            String compressedStr = new String("");
            StringBuilder sb = new StringBuilder("");
            String standardStr = s.substring(0, splitSize);
            int count = 1;
            for (int i = splitSize; i < s.length(); i += splitSize) {
                int endIndex = i + splitSize;
                if (endIndex > s.length()) {
                    endIndex = s.length();
                }
                String compareStr = s.substring(i, endIndex);

                if (standardStr.equals(compareStr)) {
                    count++;
                } else {
                    if (count != 1) {
                        sb.append(count + standardStr);
                    } else {
                        sb.append(standardStr);
                    }
                    standardStr = compareStr;
                    count = 1;
                }
            }

            if (count != 1) {
                sb.append(count);
            }
            sb.append(standardStr);

            if (sb.length() < answer) {
                answer = sb.length();
            }

            splitSize++;
        }
        return answer;
    }
}
