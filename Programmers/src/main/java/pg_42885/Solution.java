package pg_42885;

import java.util.*;

//  구명보트
//  https://school.programmers.co.kr/learn/courses/30/lessons/42885?language=java
public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

//    public static int solution(int[] people, int limit) {
//        int answer = 0;
//
//        Arrays.sort(people);
//
//        int min = 0;
//
//        for (int max = people.length - 1; min <= max; max--){
//            if (people[min] + people[max] <= limit) min++;
//            answer++;
//        }
//
//        return answer;
//    }

    public static int solution(int[] people, int limit) {
        int count = 0;
        int s = 0, e = people.length - 1;
        Boolean[] map = new Boolean[people.length];
        Arrays.fill(map, false);
        Arrays.sort(people);

        while (s != e) {
            if (map[s]) {
                s++;
                continue;
            }
            if (map[e]) {
                e--;
                continue;
            }

            if (people[s] + people[e] <= limit) {
                map[s] = true;
                map[e] = true;
                s = 0;
                e = people.length - 1;
                count++;
            }

            if (people[s] + people[e] > limit) {
                e--;
            } else {
                s++;
            }
        }

        count += Arrays.stream(map).filter(item -> !item).count();
        return count;
    }

//    public static int solution(int[] people, int limit) {
//        int count = 0;
//        int sum = 0;
//
//        Arrays.sort(people);
//
//        for (int i = 0; i < people.length; i++) {
//            if (sum + people[i] < limit) {
//                sum += people[i];
//                continue;
//            }
//            count++;
//            sum = people[i];
//
//            if (sum + people[i] == limit) {
//                sum = 0;
//            }
//        }
//
//        if (sum > 0) {
//            count++;
//        }
//
//        return count;
//    }

//    public static int solution(int[] people, int limit) {
//        Arrays.sort(people);
//        int count = 0;
//        int sum = people[people.length - 1];
//
//        for (int i = people.length - 2; i >= 0; i--) {
//            sum += people[i];
//            if (sum < limit) {
//                continue;
//            }
//
//            if (sum == limit) {
//                sum = 0;
//                count++;
//            } else if (sum > limit) {
//                sum = people[i];
//                count++;
//            }
//        }
//
//        if (sum != 0) {
//            count++;
//        }
//
//        return count;
//    }
}
