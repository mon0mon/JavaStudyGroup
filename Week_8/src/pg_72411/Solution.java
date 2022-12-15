package pg_72411;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        String[] case1 = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        for (String str : case1) {
            System.out.print(str + " ");
        }

        System.out.println();
        String[] case2 = solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
        for (String str : case2) {
            System.out.print(str + " ");
        }

        System.out.println();
        String[] case3 = solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
        for (String str : case3) {
            System.out.print(str + " ");
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> strList = List.of(orders);
        List<Integer> courseList = Arrays.stream(course).boxed().collect(Collectors.toList());
        List<String> result = new ArrayList<>();

        for (int i = 0; i < orders.length; i++) {
            if (!courseList.contains(orders[i].length())) {
                continue;
            }

            if (result.contains(orders[i])) {
                continue;
            }

            int count = 0;
            for (int j = 0; j < orders.length; j++) {
//                if (!CheckChar(orders[j], orders[i])) {
//                    continue;
//                }
//                if (orders[j].contains(orders[i])) {
//                    continue;
//                }

                count++;
            }

            if (count >= 2) {
                result.add(orders[i]);
            }
        }

        Collections.sort(result);

        return result.toArray(new String[0]);
    }

    public static boolean CheckChar(String str1, String str2) {
        for (char ch :
                str2.toCharArray()) {
            if (!str1.contains(String.valueOf(ch))) {
                return false;
            }
        }
        return true;
    }
}