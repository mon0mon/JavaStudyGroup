package pg_42746;

import java.util.*;

class Solution {
    // [3, 30, 34, 5, 9]
    // 9533430
    public static void main(String[] args) {
        int[] array = {3, 30, 34, 5, 9};

        System.out.println(solution(array));
    }

    public static String solution(int[] numbers) {
        List<Integer> integerList = new ArrayList<>();
        List<Integer> completeIntegerIndexList = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");

        for (int item :
                numbers) {
            integerList.add(item);
        }

        for (int i = 0; i < integerList.size(); i++) {
            int choice = -1;
            int choiceLog10 = 0;
            int index = 0;

            for (int j = 0; j < integerList.size(); j++) {
                if (completeIntegerIndexList.contains(j)) {
                    continue;
                }

                int holder = integerList.get(j);
                int holderLog10 = (int) Math.log10(holder);

                if (choiceLog10 != holderLog10) {
                    int choiceHolder = choice;
                    //  가장 작은 수의 자릿수로만 비교하기
                    if (choiceLog10 > holderLog10) {
                        while ((int) Math.log10(choiceHolder) != holderLog10) {
                            choiceHolder /= 10;
                        }
//                        choiceHolder = (int) (choice / Math.pow(10, holderLog10));
                    } else if (choiceLog10 < holderLog10) {
                        while ((int) Math.log10(holder) != choiceLog10) {
                            holder /= 10;
                        }
//                        holder = (int) (holder / Math.pow(10, choiceLog10));
                    }

                    if (choiceHolder < holder) {
                        index = j;
                        choice = integerList.get(j);
                        choiceLog10 = (int) Math.log10(choice);
                    }  else if (choiceHolder == holder) {
                        // 한자리 수만 구하면 되는데....
                        if (choiceLog10 > holderLog10) {
                            choiceHolder = choice;
                            while ((int) Math.log10(choiceHolder) != holderLog10 + 1) {
                                choice /= 10;
                            }

                        } else {

                        }
                    }
                } else {
                    if (choice < holder) {
                        index = j;
                        choice = integerList.get(j);
                        choiceLog10 = (int) Math.log10(choice);
                    }
                }
            }

//            integerList.remove(choice);
            completeIntegerIndexList.add(index);
            sb.append(choice);
        }

        return sb.toString();
    }
}
