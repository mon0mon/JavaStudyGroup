import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//  https://school.programmers.co.kr/learn/courses/30/lessons/17681
public class Main {
    public static void main(String[] args) {
        Arrays.stream(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28}))
                .forEach(System.out::println);
    }

    //  십진수 -> 이진수 변환
    //  변환한 이진수를 바탕으로 지도 생성 (arr1, arr2)
        //  1 -> #(벽)
        //  0 -> ' '(길)
    //  지도1과 지도2를 합쳐서 지도3을 생성
    //  생성된 지도3을 String[] 형식으로 출력
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        List<String> list1 = Arrays.stream(arr1)
                .mapToObj(i -> convertToBinary(n, i)).collect(Collectors.toList());
        List<String> list2 = Arrays.stream(arr2)
                .mapToObj(i -> convertToBinary(n, i)).collect(Collectors.toList());

        List<String> res = IntStream.range(0, n).mapToObj(idx -> {
            StringBuilder sb = new StringBuilder();
            char[] list1Parse = list1.get(idx).toCharArray();
            char[] list2Parse = list2.get(idx).toCharArray();

            for (int i = 0; i < n; i++) {
                if (list1Parse[i] == '1' || list2Parse[i] == '1') {
                    sb.append("#");
                    continue;
                }

                sb.append(" ");
            }

            return sb.toString();
        }).collect(Collectors.toList());

        return res.toArray(new String[0]);
    }

    public static String convertToBinary(int length, int n) {
        String binary = Integer.toBinaryString(n);

        if (binary.length() != length) {
            binary = "0".repeat(length - binary.length()) + binary;
        }

        return binary;
    }
}