import java.util.*;

public class Solution {
    static String[][] emptyString;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}})));
        System.out.println(Arrays.toString(Solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}})));
    }

    public static String[] solution(String[][] tickets) {
        emptyString = new String[tickets.length][];
        for (int i = 0; i < emptyString.length; i++) {
            emptyString[i] = new String[] {""};
        }

        return dfs("ICN", tickets, new String[0]);
    }

    public static String[] dfs(String word, String[][] tickets, String[] path) {
        path = Arrays.copyOf(path, path.length+1);
        path[path.length - 1] = word;
        List<String> nextAvailablePath = new ArrayList<>();
        boolean isAllPathEmpty = true;

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(word)) {
                nextAvailablePath.add(tickets[i][1]);
                tickets[i] = new String[] {""};
                isAllPathEmpty = false;
            }
        }

        if (isAllPathEmpty && Arrays.deepEquals(tickets, emptyString)) {
            return path;
        }

        if (nextAvailablePath.isEmpty()) {
            return null;
        }

        nextAvailablePath.sort(String::compareTo);
        for (String s : nextAvailablePath) {
            return dfs(s, tickets, path);
        }

        return null;
    }
}
