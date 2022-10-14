package pg_42746;

import java.util.*;

class Solution {
    // [3, 30, 34, 5, 9]
    // 9533430
    // https://school.programmers.co.kr/learn/courses/30/lessons/42746
    public static void main(String[] args) {
        int[] array = {3, 30, 34, 5, 9};

        System.out.println(solution(array));
    }

    public static String solution(int[] numbers) {
        List<Integer> intList = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        List<Integer> completeIntegerIndexList = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");

        for (int item :
                numbers) {
            intList.add(item);
            stringList.add(Integer.toString(item));
        }

        for (int i = 0; i < stringList.size(); i++) {
            String largestItem = "0";
            int index = 0;

            for (int j = 0; j < stringList.size(); j++) {
                if (completeIntegerIndexList.contains(j)) {
                    continue;
                }

                String holder = stringList.get(j);
                int holderInt;
                int largestItemInt;

                if (largestItem.length() > holder.length()) {
                    largestItemInt = Integer.parseInt(largestItem.substring(0, holder.length()));
                    holderInt = intList.get(j);

                    if (largestItemInt < holderInt) {
                        index = j;
                        largestItem = holder;
                    } else if (largestItemInt == holderInt) {
                        for (int k = 1; k < largestItem.length() - holder.length(); k++) {

                        }
                        if (Integer.parseInt(largestItem.substring(holder.length(), holder.length() + 1))
                                <= Integer.parseInt(holder.substring(0, 1))) {

                        }
                    }
                } else if (largestItem.length() < holder.length()) {
                    largestItemInt = Integer.parseInt(largestItem);
                    holderInt = Integer.parseInt(holder.substring(0, largestItem.length()));

                } else {
                    largestItemInt = Integer.parseInt(largestItem);
                    holderInt = Integer.parseInt(holder);

                    if (largestItemInt < holderInt) {
                        index = j;
                        largestItem = holder;
                    }
                }
            }
        }

        return sb.toString();
    }
}