package pg_60057;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("a"));
    }

    //테스트 1 〉	통과 (13.18ms, 74.7MB)
    //테스트 2 〉	통과 (14.17ms, 78.3MB)
    //테스트 3 〉	통과 (13.95ms, 80MB)
    //테스트 4 〉	통과 (11.65ms, 74.9MB)
    //테스트 5 〉	통과 (0.03ms, 72MB)
    //테스트 6 〉	통과 (9.09ms, 80.7MB)
    //테스트 7 〉	통과 (11.14ms, 77MB)
    //테스트 8 〉	통과 (10.77ms, 75MB)
    //테스트 9 〉	통과 (13.77ms, 73.1MB)
    //테스트 10 〉	통과 (20.11ms, 72.6MB)
    //테스트 11 〉	통과 (13.74ms, 71.2MB)
    //테스트 12 〉	통과 (17.23ms, 76MB)
    //테스트 13 〉	통과 (12.07ms, 79.6MB)
    //테스트 14 〉	통과 (11.76ms, 73.6MB)
    //테스트 15 〉	통과 (10.45ms, 79.8MB)
    //테스트 16 〉	통과 (0.12ms, 78.5MB)
    //테스트 17 〉	통과 (10.12ms, 74.4MB)
    //테스트 18 〉	통과 (11.63ms, 77.5MB)
    //테스트 19 〉	통과 (12.48ms, 78.7MB)
    //테스트 20 〉	통과 (15.23ms, 81MB)
    //테스트 21 〉	통과 (15.05ms, 76.9MB)
    //테스트 22 〉	통과 (13.48ms, 76.8MB)
    //테스트 23 〉	통과 (15.31ms, 89.1MB)
    //테스트 24 〉	통과 (11.48ms, 80.4MB)
    //테스트 25 〉	통과 (13.98ms, 80.2MB)
    //테스트 26 〉	통과 (15.57ms, 84.8MB)
    //테스트 27 〉	통과 (13.95ms, 76MB)
    //테스트 28 〉	통과 (13.14ms, 68.1MB)
    //채점 결과
    //정확성: 100.0
    //합계: 100.0 / 100.0
    public static int solution(String s) {
        //  https://school.programmers.co.kr/questions/20870
        //  테스트 케이스 5번 실패는 문자열 크기가 1일때의 경우
        //  기존 코드에서는 while 반복문을 거치지 않고 바로 통과했기에, 문제가 발생...
        int answer = s.length();
        int splitSize = 1;
        StringBuilder sb;
        String compressedStr;
        String standardStr;

        while (splitSize <= s.length() / 2) {
            sb = new StringBuilder("");
            compressedStr = new String("");
            standardStr = s.substring(0, splitSize);
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
                    }
                    sb.append(standardStr);
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
