package pg_60057;

// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }

    //테스트 1 〉	통과 (18.90ms, 78.9MB)
    //테스트 2 〉	실패 (19.33ms, 84.3MB)
    //테스트 3 〉	실패 (19.18ms, 85.7MB)
    //테스트 4 〉	통과 (20.13ms, 79.6MB)
    //테스트 5 〉	실패 (0.03ms, 77.6MB)
    //테스트 6 〉	실패 (18.49ms, 72.8MB)
    //테스트 7 〉	통과 (19.79ms, 90.3MB)
    //테스트 8 〉	통과 (20.60ms, 85.8MB)
    //테스트 9 〉	통과 (20.91ms, 75.7MB)
    //테스트 10 〉	통과 (28.40ms, 80.7MB)
    //테스트 11 〉	실패 (22.52ms, 77.5MB)
    //테스트 12 〉	실패 (20.54ms, 75.6MB)
    //테스트 13 〉	통과 (19.00ms, 75.3MB)
    //테스트 14 〉	실패 (16.94ms, 75MB)
    //테스트 15 〉	실패 (17.77ms, 80.6MB)
    //테스트 16 〉	통과 (11.54ms, 74.6MB)
    //테스트 17 〉	실패 (17.44ms, 84MB)
    //테스트 18 〉	통과 (17.20ms, 81.5MB)
    //테스트 19 〉	통과 (18.87ms, 81.4MB)
    //테스트 20 〉	통과 (20.51ms, 82.6MB)
    //테스트 21 〉	통과 (28.63ms, 93.4MB)
    //테스트 22 〉	통과 (29.44ms, 80.7MB)
    //테스트 23 〉	통과 (27.38ms, 86.2MB)
    //테스트 24 〉	통과 (36.46ms, 87MB)
    //테스트 25 〉	통과 (32.20ms, 84.4MB)
    //테스트 26 〉	실패 (28.02ms, 89.9MB)
    //테스트 27 〉	실패 (27.75ms, 81.7MB)
    //테스트 28 〉	실패 (22.06ms, 85MB)
    //채점 결과
    //정확성: 58.0
    //합계: 58.0 / 100.0
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int splitSize = 1;

        while (splitSize <= s.length() / 2) {
            String compressedStr = new String("");
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
                        compressedStr = compressedStr + count + holder;
                    }
                    continue;
                }

                if (count < 2) {
                    if (i + splitSize >= s.length()) {
                        compressedStr = compressedStr + holder + subStr;
                        break;
                    }
                    compressedStr = compressedStr + holder;
                } else {
                    compressedStr = compressedStr + count + holder;
                }
                holder = subStr;
                count = 1;
            }

            if (compressedStr.length() < answer) {
                answer = compressedStr.length();
            }

            splitSize++;
        }
        return answer;
    }
}
