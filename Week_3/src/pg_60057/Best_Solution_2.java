package pg_60057;

//  https://school.programmers.co.kr/learn/courses/30/lessons/60057/solution_groups?language=java
//  황재익 , 김봉한 , - , 정현 , 재재 외 3 명

class Best_Solution_2 {
    public int solution(String s) {
        int min = s.length();
        int len = s.length()/2+1;
        //  i는 문자열을 나누는 크기 (splitSize)
        for(int i = 1; i < len; i++) {
            String before = "";
            int sum = 0;
            int cnt = 1;
            //  j는 문자열을 자르는 시작 인덱스
            for(int j = 0; j < s.length();) {
                int start = j;
                //  문자열 크기보다 더 클 경우, 문자열 크기대로만 자르기
                //  ex) 문자열 크기가 9이고, i가 2일때,
                //  8-10 X, 8-9 O
                j = (j+i > s.length()) ? s.length():j+i;
                String temp = s.substring(start, j);
                if(temp.equals(before)) {
                    cnt++;
                } else {
                    if(cnt != 1) {
                        sum += (int)Math.log10(cnt)+1;
                    }
                    cnt = 1;
                    sum+=before.length();
                    before = temp;
                }
            }
            sum+=before.length();
            if(cnt != 1) {
                sum += (int)Math.log10(cnt)+1;
            }
            min = (min > sum) ? sum : min;
        }

        return min;
    }
}
