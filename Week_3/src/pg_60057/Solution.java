package pg_60057;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(solution("xababcdcdababcdcd"));
    }

    //테스트 1 〉	통과 (3.38ms, 81.8MB)
    //테스트 2 〉	실패 (7.50ms, 79.5MB)
    //테스트 3 〉	통과 (4.87ms, 71.9MB)
    //테스트 4 〉	실패 (런타임 에러)
    //테스트 5 〉	실패 (0.04ms, 73.3MB)
    //테스트 6 〉	실패 (런타임 에러)
    //테스트 7 〉	실패 (런타임 에러)
    //테스트 8 〉	실패 (런타임 에러)
    //테스트 9 〉	실패 (런타임 에러)
    //테스트 10 〉	통과 (32.08ms, 94.4MB)
    //테스트 11 〉	통과 (3.65ms, 74.6MB)
    //테스트 12 〉	통과 (4.67ms, 77.5MB)
    //테스트 13 〉	통과 (5.98ms, 72.2MB)
    //테스트 14 〉	통과 (11.31ms, 82.3MB)
    //테스트 15 〉	통과 (4.53ms, 81.3MB)
    //테스트 16 〉	통과 (2.56ms, 74.5MB)
    //테스트 17 〉	실패 (런타임 에러)
    //테스트 18 〉	실패 (런타임 에러)
    //테스트 19 〉	통과 (19.87ms, 86.4MB)
    //테스트 20 〉	실패 (런타임 에러)
    //테스트 21 〉	실패 (런타임 에러)
    //테스트 22 〉	통과 (40.29ms, 95.7MB)
    //테스트 23 〉	실패 (런타임 에러)
    //테스트 24 〉	통과 (31.63ms, 100MB)
    //테스트 25 〉	통과 (29.45ms, 107MB)
    //테스트 26 〉	실패 (런타임 에러)
    //테스트 27 〉	실패 (런타임 에러)
    //테스트 28 〉	통과 (2.43ms, 71.7MB)
    //정확성: 50.0
    //합계: 50.0 / 100.0
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int splitSize = 1;

        while (splitSize <= s.length() / 2) {
            String compressedStr = new String("");
            StringBuilder sb;
            for (int i = 0; i < s.length(); i += splitSize) {
                String subStr;
                if (i + splitSize > s.length()) {
                    subStr = s.substring(i);
                } else {
                    subStr = s.substring(i, i + splitSize);
                }

                if (compressedStr.isEmpty()) {
                    compressedStr = "1" + subStr;
                    continue;
                }

                if (compressedStr.substring(compressedStr.length()-splitSize)
                        .equals(subStr)) {
                    sb = new StringBuilder(compressedStr);
                    int wordCount = Integer.parseInt(
                            compressedStr.substring(compressedStr.length()-1-splitSize, compressedStr.length()-splitSize));
                    sb.setCharAt(compressedStr.length()-1-splitSize, Character.forDigit(wordCount+1, 10));
                    compressedStr = sb.toString();
                    continue;
                }

                sb = new StringBuilder(compressedStr);
                sb.append("1" + subStr);
                compressedStr = sb.toString();
            }

            compressedStr = compressedStr.replaceAll("1", "");

            if (compressedStr.length() < answer) {
                answer = compressedStr.length();
            }

            splitSize++;
        }

        return answer;
    }
}
