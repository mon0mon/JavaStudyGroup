import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Arrays.stream(solution(6, new int[]{46, 33, 33 ,22, 31, 50}, new int[]{27 ,56, 19, 14, 14, 10}))
                .forEach(System.out::println);
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        int[] num = new int[n];

        String answer[] = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = "";
        }

        for (int i = 0; i < n; i++) {
            num[i] = arr1[i] | arr2[i];
        }

        for (int i = 0; i < n; i++) {
            for (int ii = 0; ii < n; ii++) {
                // i = 3, ii = 5
                // 1 1110 (length 5)
                if ('1' == Integer.toBinaryString(num[i]).charAt(ii)) {
                    answer[i] += "#";
                }
                if ('0' == Integer.toBinaryString(num[i]).charAt(ii)) {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }
}
