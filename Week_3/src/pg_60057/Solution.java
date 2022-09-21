package pg_60057;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(solution("ababcdcdababcdcd"));
    }

    //테스트 1 〉	통과 (16.95ms, 70.1MB)
    //테스트 2 〉	실패 (18.94ms, 86.7MB)
    //테스트 3 〉	통과 (26.86ms, 85.1MB)
    //테스트 4 〉	통과 (28.66ms, 75.1MB)
    //테스트 5 〉	실패 (0.03ms, 74.4MB)
    //테스트 6 〉	실패 (32.16ms, 78.5MB)
    //테스트 7 〉	통과 (25.13ms, 80.8MB)
    //테스트 8 〉	통과 (23.58ms, 77.5MB)
    //테스트 9 〉	통과 (25.17ms, 73.2MB)
    //테스트 10 〉	통과 (29.03ms, 78.3MB)
    //테스트 11 〉	실패 (18.93ms, 75MB)
    //테스트 12 〉	실패 (23.97ms, 89.2MB)
    //테스트 13 〉	통과 (20.93ms, 81.9MB)
    //테스트 14 〉	실패 (23.58ms, 83.6MB)
    //테스트 15 〉	실패 (23.10ms, 72.2MB)
    //테스트 16 〉	통과 (21.66ms, 83MB)
    //테스트 17 〉	실패 (23.80ms, 90MB)
    //테스트 18 〉	통과 (19.68ms, 80.5MB)
    //테스트 19 〉	통과 (25.62ms, 82.5MB)
    //테스트 20 〉	통과 (23.77ms, 82.1MB)
    //테스트 21 〉	통과 (28.67ms, 91.2MB)
    //테스트 22 〉	통과 (32.32ms, 80.6MB)
    //테스트 23 〉	통과 (33.33ms, 77.1MB)
    //테스트 24 〉	통과 (26.31ms, 92.4MB)
    //테스트 25 〉	통과 (36.53ms, 85.1MB)
    //테스트 26 〉	실패 (50.15ms, 75.8MB)
    //테스트 27 〉	실패 (72.45ms, 93.1MB)
    //테스트 28 〉	실패 (14.14ms, 77.3MB)
    //채점 결과
    //정확성: 62.0
    //합계: 62.0 / 100.0
    public int solution(String s) {
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

                if (i + splitSize >= s.length()) {
                    if (holder.equals(subStr)) {
                        count++;
                        compressedStr = compressedStr + count + holder;
                        break;
                    }

                    compressedStr = compressedStr + holder + subStr;
                    break;
                }

                if (subStr.equals(holder)) {
                    count++;
                    continue;
                }

                if (count < 2) {
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
