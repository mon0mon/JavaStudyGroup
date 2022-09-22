package pg_60057;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    //테스트 1 〉	통과 (10.99ms, 81.4MB)
    //테스트 2 〉	실패 (11.88ms, 87.3MB)
    //테스트 3 〉	실패 (12.96ms, 70.8MB)
    //테스트 4 〉	통과 (9.22ms, 76.9MB)
    //테스트 5 〉	실패 (0.01ms, 76.2MB)
    //테스트 6 〉	실패 (10.71ms, 79.1MB)
    //테스트 7 〉	통과 (14.10ms, 84.8MB)
    //테스트 8 〉	통과 (13.61ms, 74.3MB)
    //테스트 9 〉	통과 (13.04ms, 75.7MB)
    //테스트 10 〉	통과 (16.68ms, 78.4MB)
    //테스트 11 〉	실패 (10.64ms, 82.9MB)
    //테스트 12 〉	실패 (9.32ms, 73.5MB)
    //테스트 13 〉	통과 (13.11ms, 80.4MB)
    //테스트 14 〉	실패 (9.93ms, 79.8MB)
    //테스트 15 〉	실패 (11.97ms, 77.4MB)
    //테스트 16 〉	통과 (1.23ms, 79.8MB)
    //테스트 17 〉	실패 (15.91ms, 77.1MB)
    //테스트 18 〉	통과 (15.23ms, 80.5MB)
    //테스트 19 〉	통과 (12.78ms, 77.8MB)
    //테스트 20 〉	통과 (22.88ms, 81.5MB)
    //테스트 21 〉	통과 (12.31ms, 71.7MB)
    //테스트 22 〉	통과 (12.65ms, 84.5MB)
    //테스트 23 〉	통과 (17.34ms, 84.1MB)
    //테스트 24 〉	통과 (13.96ms, 73.3MB)
    //테스트 25 〉	통과 (18.95ms, 79.3MB)
    //테스트 26 〉	실패 (18.78ms, 83.2MB)
    //테스트 27 〉	실패 (14.75ms, 85.8MB)
    //테스트 28 〉	실패 (10.60ms, 76.5MB)
    //채점 결과
    //정확성: 58.0
    //합계: 58.0 / 100.0
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int splitSize = 1;

        while (splitSize <= s.length() / 2) {
            String compressedStr = new String("");
            StringBuilder sb = new StringBuilder("");
            String holder = "";
            int count = 1;
            for (int i = 0; i < s.length(); i += splitSize) {
                String subStr;
                if (i + splitSize > s.length()) {
                    subStr = s.substring(i);
                } else {
                    subStr = s.substring(i, i + splitSize);
                }

                if (holder.isEmpty()) {
                    holder = subStr;
                    continue;
                }

                if (subStr.equals(holder)) {
                    count++;
                    if (i + splitSize >= s.length()) {
                        sb.append(count + holder);
                    }
                    continue;
                }

                if (count < 2) {
                    if (i + splitSize >= s.length()) {
                        sb.append(holder + subStr);
                        break;
                    }
                    sb.append(holder);
                } else {
                    sb.append(count + holder);
                }
                holder = subStr;
                count = 1;
            }

            if (sb.length() < answer) {
                answer = sb.length();
            }

            splitSize++;
        }
        return answer;
    }
}
