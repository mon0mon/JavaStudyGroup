import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        startLinkProgram();
    }

    public static void startLinkProgram() throws IOException {
        Integer[][] map = processUserInput();

    }

    public static Integer[][] processUserInput() throws IOException {
        int length = Integer.parseInt(new Scanner(System.in).nextLine());
        Integer [][] map = new Integer[length][length];
        List<Integer> listInt = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String row = new BufferedReader(new InputStreamReader(System.in)).readLine();
            Arrays.stream(row.split(" ")).forEach(j -> listInt.add(Integer.valueOf(j)));
            map[i] = listInt.toArray(new Integer[0]);
            listInt.clear();
        }

        return map;
    }

    public static void calculateMinDiff(Integer[][] map) {
        List<Integer> minValue = calculateDiff(map);
        System.out.println(minValue.stream().min(Integer::compareTo));
    }

    public static List<Integer> calculateDiff(Integer[][] map) {
        List<Integer> diff = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == j) {
                    continue;
                }


            }
        }

        return null;
    }
}