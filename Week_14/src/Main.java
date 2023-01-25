import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//public class Main {
//    //  https://www.acmicpc.net/problem/14499
//
//    public static int[] moveX = {0, 0, -1, 1};
//    public static int[] moveY = {1, -1, 0, 0};
//    public static int[] dice = new int[6];
//    public static int[][] map;
//    //  [0] -> x, [1] -> y
//    public static int[] currentPosition = new int[2];
//    //  N * M (N은 세로, M은 가로)
//    public static int N, M;
//    public static int[] commandToMove;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
//
//        int[] inputCom = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//        //  N은 세로, M은 가로
//        //  x,y는 현재 주사위 위치
//        //  comCount는 명령어 갯수
//        N = inputCom[0];
//        M = inputCom[1];
//        currentPosition[0] = inputCom[2];
//        currentPosition[1] = inputCom[3];
//        int comCount = inputCom[4];
//
//        map = new int[N][M];
//
//        //  맵 생성
//        for (int i = 0; i < N; i++) {
//            map[i] = generateMap(M, comCount, br);
//        }
//
////        System.out.println("\n" + Arrays.deepToString(map));
//        commandToMove = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
////        br.close();
//
//        for (int i = 0; i < commandToMove.length; i++) {
//            System.out.println(rollDice(commandToMove[i]));
//        }
//    }
//
//    public static int[] generateMap(int M, int comCount, BufferedReader br) throws IOException {
//        int[] inputCom = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt).toArray();
//
//        return inputCom;
//    }
//
//    public static int rollDice(int com) {
//        switch(com) {
//            case 1:
//                swap(0, 2);
//                swap(1, 2);
//                swap(2, 5);
//                break;
//            case 2:
//                swap(0, 1);
//                swap(1, 2);
//                swap(1, 5);
//                break;
//            case 3:
//                swap(1, 2);
//                swap(0, 3);
//                swap(3, 5);
//                swap(4, 5);
//                break;
//            case 4:
//                swap(1, 2);
//                swap(0, 3);
//                swap(4, 5);
//                swap(0, 5);
//                break;
//        }
//        currentPosition[0] = Math.max(currentPosition[0] + moveX[com - 1], 0);
//        currentPosition[1] = Math.max(currentPosition[1] + moveY[com - 1], 0);
//
//        calculateFloorAndDiceNumber();
//
//        return getDiceUpperPart();
//    }
//
//    public static int getDiceUpperPart() {
//        return dice[0];
//    }
//
//    public static int getDiceFloorPart() {
//        return dice[5];
//    }
//
//    public static void setDiceFloorPart(int number) {
//        dice[5] = number;
//    }
//
//    public static void calculateFloorAndDiceNumber() {
//        if (map[currentPosition[0]][currentPosition[1]] != 0) {
//            setDiceFloorPart(map[currentPosition[0]][currentPosition[1]]);
//            map[currentPosition[0]][currentPosition[1]] = 0;
//            return;
//        }
//
//        map[currentPosition[0]][currentPosition[1]] = getDiceFloorPart();
//    }
//
//    public static void swap(int x1, int x2) {
//        int holder = dice[x1];
//        dice[x1] = dice[x2];
//        dice[x2] = holder;
//    }
//}

public class Main {
    public static void main(String[] args) {
        solve();
    }

    static Scanner sc = new Scanner(System.in);
    static int[] dice = new int[7];
    static int[][] map = new int[20][20];
    static int[] dx = { 1, -1, 0, 0 }; // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
    static int[] dy = { 0, 0, -1, 1 };
    static StringBuilder sb = new StringBuilder();

    private static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int y = sc.nextInt();
        int x = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < k; i++) {
            int d = sc.nextInt();
            int nx = dx[d - 1] + x;
            int ny = dy[d - 1] + y;

            if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                changeDice(d);

                if (map[ny][nx] == 0) {
                    map[ny][nx] = dice[6];
                } else {
                    dice[6] = map[ny][nx];
                    map[ny][nx] = 0;
                }

                x = nx;
                y = ny;
                sb.append(dice[1] + "\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static void changeDice(int d) {
        int[] temp = dice.clone();
        // 6 밑면, 1 윗면
        // 동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        if (d == 1) {
            dice[1] = temp[4];
            dice[3] = temp[1];
            dice[4] = temp[6];
            dice[6] = temp[3];
        } else if (d == 2) {
            dice[1] = temp[3];
            dice[3] = temp[6];
            dice[4] = temp[1];
            dice[6] = temp[4];
        } else if (d == 3) {
            dice[1] = temp[5];
            dice[2] = temp[1];
            dice[5] = temp[6];
            dice[6] = temp[2];
        } else {
            dice[1] = temp[2];
            dice[2] = temp[6];
            dice[5] = temp[1];
            dice[6] = temp[5];
        }
    }

}
