package pg_60057;

//  https://school.programmers.co.kr/learn/courses/30/lessons/60057/solution_groups?language=java
//  송동훈 , choiyeonseok , - , Jaeweon Kim , Oh-Myeongjae 외 3 명
class Best_Solution_1 {
    public static int solution(String s) {
        int answer = 0;

        for(int i=1; i<=(s.length()/2)+1; i++){
            int result = getSplitedLength(s, i, 1).length();
            answer =
                    i==1 ? result :
                            (answer>result?result:answer);
        }

        return answer;
    }

    /**
     * 재귀 방식 호출을 이용해서 문자열을 나눔
     * 'aaabbbccc'가 주어진다면, 우선 preString으로 첫 문자의 값을 가지고, postString으로 나머지 문자열의 값을 가짐
     * preString = 'a', postString = 'aabbbccc'
     * 이제 postString의 문자 시작이 preString과 같은지 비교(startWith 메소드 이용)
     * 동일하다면, return getSplitedLength(postString, 1, 2)로 재귀호출
     * 위와 같은 방식으로 더이상 문자열이 남아있지 않을때까지 반복
     * @param s
     * 주어진 문자열
     * @param n
     * 문자열을 자르는 크기
     * @param repeat
     * 반복된 문자열 패턴 카운트
     * @return
     */
    public static String getSplitedLength(String s, int n, int repeat){
        if(s.length() < n) return s;
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n, s.length());

        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
        if(!postString.startsWith(preString)){
            if(repeat ==1)
                return result += preString + getSplitedLength(postString, n, 1);
            return result += Integer.toString(repeat)
                    + preString + getSplitedLength(postString, n, 1);
        }

        return result += getSplitedLength(postString, n, repeat+1);
    }

    public static void main(String[] args) {
        System.out.println(solution("aabbaccc"));
    }
}
