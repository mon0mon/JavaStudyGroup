import java.util.*;

public class Main {
    public static void main(String[] args) {
        Arrays.stream(solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"}))
                .forEach(System.out::println);
    }

    public static int[] solution(int[] fees, String[] records) {
        List<Integer> parseResult = parseRecords(records);
        int[] res = new int[parseResult.size()];

        for (int i = 0; i < res.length; i++) {
            int holder = parseResult.get(i) - fees[0];

            if (holder <= 0) {
                res[i] = fees[1];
                continue;
            }

            if (holder % fees[2] != 0) {
                holder = holder / fees[2] + 1;
            } else {
                holder = holder / fees[2];
            }

            holder = holder * fees[3] + fees[1];

            res[i] = holder;
        }

        return res;
    }

    public static List<Integer> parseRecords(String[] records) {
        Map<Integer, String> carLog = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> keyList;

        for (String history :
                records) {
            String[] parseHistory = history.split(" ");
            String logTime = parseHistory[0];
            Integer carNumber = Integer.parseInt(parseHistory[1]);

            if (!isCarHistoryExist(carLog, carNumber)) {
                carLog.put(carNumber, logTime);
                continue;
            }

            if (isCarEntering(parseHistory[2])) {
                carLog.put(carNumber, carLog.get(carNumber) + "," + logTime);
                continue;
            }

            carLog.put(carNumber,
                    updateSpentTime(carLog, carNumber, logTime));
        }

        keyList = new ArrayList<> (carLog.keySet());
        Collections.sort(keyList);
        keyList.stream().forEach(i -> {
            if (isCarLeft(carLog, i)) {
                carLog.put(i, updateSpentTime(carLog, i, "23:59"));
            }

            res.add(Integer.parseInt(carLog.get(i)));
        });

        return res;
    }

    public static boolean isCarLeft(Map<Integer, String> carHistory, Integer carNumber) {
        String[] carLog = carHistory.get(carNumber).split(",");

        if (carLog.length != 1) {
            return true;
        }

        try {
            int holder = Integer.parseInt(carLog[0]);
        } catch (NumberFormatException ex) {
            return true;
        }

        return false;
    }

    public static boolean isCarHistoryExist(Map<Integer, String> carHistory, Integer carNumber) {
        return carHistory.containsKey(carNumber);
    }

    public static boolean isCarEntering(String log) {
        return "IN".equalsIgnoreCase(log);
    }

    public static String updateSpentTime(Map<Integer, String> carHistory, Integer carNumber, String outTime) {
        String[] holder = carHistory.get(carNumber).split(",");
        String inTime = holder[holder.length - 1];

        Integer calculatedTime = calculateTime(inTime, outTime);

        if (!holder[0].equals(inTime)) {
            calculatedTime += Integer.parseInt(holder[0]);
        }

        return String.valueOf(calculatedTime);
    }

    public static Integer calculateTime(String inTime, String outTime) {
        String[] inTimeAry = inTime.split(":");
        String[] outTimeAry = outTime.split(":");

        Integer inTimeInteger = (Integer.parseInt(inTimeAry[0]) * 60) + (Integer.parseInt(inTimeAry[1]));
        Integer outTimeInteger = (Integer.parseInt(outTimeAry[0]) * 60) + (Integer.parseInt(outTimeAry[1]));

        return outTimeInteger - inTimeInteger;
    }
}