import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));
        System.out.println(solution(new int[][] {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}}));
    }

    static boolean[][] visited;
    static int[] dx = new int[] {1, -1, 0, 0};
    static int[] dy = new int[] {0, 0, 1, -1};
    static int n;
    static int m;

    public static int solution(int[][] maps) {
        return bfs(maps);
    }

    public static int bfs(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        m = maps.length;
        n = maps[0].length;
        visited = new boolean[m][n];
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int y = queue.peek()[0];
            int x = queue.poll()[1];
            visited[y][x] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (maps[ny][nx] == 0) continue;

                if (maps[ny][nx] == 1 && !visited[ny][nx]) {
                    maps[ny][nx] = maps[y][x] + 1;
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny, nx});
                }
            }
        }

        return maps[m-1][n-1] == 1 ? -1 : maps[m-1][n-1];
    }
}
