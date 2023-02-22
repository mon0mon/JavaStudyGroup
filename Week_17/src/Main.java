import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // https://www.acmicpc.net/problem/1904
    static Integer[] arr = new Integer[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        if (N == 1) {
//            System.out.println("1");
//            return;
//        }
//
//        if (N == 2) {
//            System.out.println("2");
//            return;
//        }
//
//        //  가장 단순한 방법이지만 타임 아웃
//        int count = 0;
//        for (int i = 0; i < Math.pow(2, N); i++) {
//            String bin = Integer.toBinaryString(i);
//            bin = "0".repeat(N - bin.length()) + bin;
//            bin = bin.replaceAll("00", "");
//            bin = bin.replaceAll("1", "");
//
//            if (bin.length() == 0) {
//                count++;
//            }
//        }

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        System.out.println(recursiveArr(N));
    }

    static int recursiveArr(int N) {
        if (arr[N] == null) {
            arr[N] = (recursiveArr(N-2) + recursiveArr(N-1)) % 15746;
        }

        return arr[N];
    }
}
