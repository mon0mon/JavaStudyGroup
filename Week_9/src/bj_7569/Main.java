package bj_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//  https://www.acmicpc.net/problem/7569
public class Main {
    static List<List<List<Integer>>> tomatoChest = new ArrayList<>();
    static List<Integer> matrix = new ArrayList<>();
    static List<List<Integer>> matureTomatoIdx = new ArrayList<>();
    static int redTomatoCount = 0;
    static int blockCount = 0;

    public static void main(String[] args) throws IOException {
        System.out.println(solution());
    }

    public static int solution() throws IOException {
        int checkTomatoViableFlag;
        int day = 1;

        initTomato();

        checkTomatoViableFlag = checkTomatoViable();

        if (checkTomatoViableFlag != 1) {
            return checkTomatoViableFlag;
        }

        while (true) {
            switch(maturingTomato()) {
                case -1 :
                    return -1;
                case 0:
                    return day;
                case 1 :
                default:
                    day++;
            }
        }
    }

    public static void initTomato() throws IOException {
        List<Integer> holder = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isAllTomatoMature = true;
        boolean isTomatoNotExit = true;

        Arrays.stream(br.readLine().split(" ")).
                forEach((item) -> matrix.add(Integer.valueOf(item)));

        for (int i = 0; i < Math.max(1, matrix.get(2)); i++) {
            tomatoChest.add(new ArrayList<>());

            for (int j = 0; j < Math.max(1, matrix.get(1)); j++) {
                holder.clear();
                int finalI = i;
                int finalJ = j;
                AtomicInteger idx = new AtomicInteger();
                Arrays.stream(br.readLine().split(" "))
                        .forEach((item) -> {
                            holder.add(Integer.valueOf(item));
                            if (Integer.valueOf(item) == 1) {
                                matureTomatoIdx.add(Stream.of
                                        (finalI, finalJ, idx.get()).collect(Collectors.toList()));
                            }
                            idx.getAndIncrement();
                        });

                tomatoChest.get(i).add(new ArrayList<> (holder));
            }
        }
    }

    public static int checkTomatoViable() {
        AtomicInteger matureTomatoCount = new AtomicInteger();
        AtomicInteger immatureTomatoCount = new AtomicInteger();
        AtomicInteger emptyBlockCount = new AtomicInteger();
        int totalBlockCount = matrix.get(0) * matrix.get(1) * matrix.get(2);

        tomatoChest.stream().forEach((n) -> n.forEach(
                (m) -> m.forEach(
                        (block) -> {
                            switch (block) {
                                case -1 :
                                    emptyBlockCount.getAndIncrement();
                                    break;
                                case 0 :
                                    immatureTomatoCount.getAndIncrement();
                                    break;
                                case 1:
                                default :
                                    matureTomatoCount.getAndIncrement();
                            }
                        }
                )
        ));

        //  빈 칸이 전부일 경우
        if (emptyBlockCount.get() == totalBlockCount) {
            return -1;
        }

        //  익은 토마토와 빈 칸이 전부일 경우
        if (matureTomatoCount.get() + emptyBlockCount.get() == totalBlockCount) {
            return 0;
        }

        redTomatoCount = matureTomatoCount.get();
        blockCount = emptyBlockCount.get();

        return 1;
    }

    public static int maturingTomato() {
        int changeCount = 0;
        List<List<Integer>> newMatureTomatoIdx = new ArrayList<>();

        for (List<Integer> loc:matureTomatoIdx) {
            //  현재 익은 토마토의 위치
            tomatoChest.get(loc.get(0)).get(loc.get(1)).get(loc.get(2));
            //  [h][m][n-1]
            if (loc.get(2) > 0 && tomatoChest.get(loc.get(0)).get(loc.get(1)).get(loc.get(2) - 1) != 1) {
                tomatoChest.get(loc.get(0)).get(loc.get(1)).set(loc.get(2)-1, 1);
                redTomatoCount++;
                newMatureTomatoIdx.add(Stream.of(loc.get(0), loc.get(1), loc.get(2) - 1)
                        .collect(Collectors.toList()));
            }
            //  [h][m][n+1]
            if (loc.get(2) < matrix.get(0) - 1 &&
                    tomatoChest.get(loc.get(0)).get(loc.get(1)).get(loc.get(2) + 1) != 1) {
                tomatoChest.get(loc.get(0)).get(loc.get(1)).set(loc.get(2)+1, 1);
                redTomatoCount++;
                newMatureTomatoIdx.add(Stream.of(loc.get(0), loc.get(1), loc.get(2) + 1)
                        .collect(Collectors.toList()));
            }
            //  [h][n-1][m]
            if (loc.get(1) > 0 &&
                    tomatoChest.get(loc.get(0)).get(loc.get(1) - 1).get(loc.get(2)) != 1) {
                tomatoChest.get(loc.get(0)).get(loc.get(1) - 1).set(loc.get(2), 1);
                redTomatoCount++;
                newMatureTomatoIdx.add(Stream.of(loc.get(0), loc.get(1) - 1, loc.get(2))
                        .collect(Collectors.toList()));
            }
            //  [h][n+1][m]
            if (loc.get(1) < matrix.get(1) -1
                && tomatoChest.get(loc.get(0)).get(loc.get(1) + 1).get(loc.get(2)) != 1) {
                tomatoChest.get(loc.get(0)).get(loc.get(1) + 1).set(loc.get(2), 1);
                redTomatoCount++;
                newMatureTomatoIdx.add(Stream.of(loc.get(0), loc.get(1) + 1, loc.get(2))
                        .collect(Collectors.toList()));
            }
            //  [h-1][n][m]
            if (loc.get(0) > 0 &&
                    tomatoChest.get(loc.get(0) - 1).get(loc.get(1)).get(loc.get(2)) != 1) {
                tomatoChest.get(loc.get(0) - 1).get(loc.get(1)).set(loc.get(2), 1);
                redTomatoCount++;
                newMatureTomatoIdx.add(Stream.of(loc.get(0) - 1, loc.get(1), loc.get(2))
                        .collect(Collectors.toList()));
            }
            //  [h+1][n][m]
            if (loc.get(0) < matrix.get(2) - 1 &&
                    tomatoChest.get(loc.get(0) + 1).get(loc.get(1)).get(loc.get(2)) != 1) {
                tomatoChest.get(loc.get(0) + 1).get(loc.get(1)).set(loc.get(2), 1);
                redTomatoCount++;
                newMatureTomatoIdx.add(Stream.of(loc.get(0) + 1, loc.get(1), loc.get(2))
                        .collect(Collectors.toList()));
            }
                changeCount++;
        }

        //  덜 익은 토마토들이 모두 익은 것이 완료된 것을 알림
        if (redTomatoCount + blockCount == matrix.get(0) * matrix.get(1) * matrix.get(2)) {
            return 0;
        }

        //  모두 성숙하지 않았음에도 변화가 없음을 알림 (모두 성숙 X)
        if (changeCount == 0) {
            return -1;
        }

        matureTomatoIdx = newMatureTomatoIdx;

        //  전부 성숙하진 않았지만, 변화가 있음을 알림
        return 1;
    }
}
