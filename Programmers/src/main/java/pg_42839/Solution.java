package pg_42839;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    public static int solution(String numbers) {
        List<String> strList = new ArrayList<>(Arrays.asList(numbers));
        Set<Integer> intSet = new HashSet<>();
        int count = 0;

        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 0; j < numbers.length(); j++) {
                for (String s : getPossibleNumberCombination(strList,
                        j, i+1)) {
                    intSet.add(Integer.parseInt(s));
                }
            }
        }

        for (int num :
                intSet) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    public static List<String> getPossibleNumberCombination(List<String> strList,
                                                            int startIdx, int numberLength) {
        List<String> res = new ArrayList<>();
        String str;
        StringBuilder sb = new StringBuilder();
        int endIdx = startIdx + numberLength - 1;

        for (String s :
                strList) {
            sb.append(s);
        }
        str = sb.toString();
        endIdx = Math.min(endIdx, str.length());

        if (numberLength == 1) {
            res.add(str.substring(startIdx, Math.min(startIdx + 1, str.length())));
            for (int i = 0; i < str.length(); i++) {
                if (startIdx == i) {
                    continue;
                }

                res.add(str.substring(i, Math.min(i + 1, str.length())));
            }
        } else {
            sb = new StringBuilder(str.substring(startIdx, endIdx));
            for (int i = 0; i < str.length(); i++) {
                if (startIdx <= i && i < endIdx) {
                    continue;
                }

                sb.append(str, i, Math.min(i+1, str.length()));
            }
            res.add(sb.toString());
        }


        return res;
    }

    public static boolean isPrime(int number) {
        int index = 2;

        if (number < 2) {
            return false;
        }

        if (number == 2) {
            return true;
        }

        while (index != number) {
            if (number % index == 0) {
                return false;
            }
            index++;
        }

        return true;
    }
}
