package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.24
 * @notes - 메모 없이 풀어보자, 시간초과 각 수정 필요<br>
 */

public class _failed_s4_2459_걷기 {
    public static int MAX_POSITION = 1_000_000_000;
    public static int[] dX = new int[]{1, 0, 1};
    public static int[] dY = new int[]{0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        MAX_POSITION = Math.max(X, Y);

        long[][] times = new long[MAX_POSITION + 1][MAX_POSITION + 1];
        boolean[][] visited = new boolean[MAX_POSITION + 1][MAX_POSITION + 1];

        // BFS 탐색
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{0, 0});
        while (!Q.isEmpty()) {
            int[] p = Q.poll();
            if (visited[p[0]][p[1]])
                continue;

            for (int k = 0; k < 3; k++) {
                int newX = p[0] + dX[k];
                int newY = p[1] + dY[k];

                // 범위 벗어난다면 건너뛰기
                if (newX > MAX_POSITION || newY > MAX_POSITION)
                    continue;

                // 시간 업데이트
                int moveTime = k == 2 ? S : W;
                times[newX][newY] = Math.min(times[newX][newY], times[p[0]][p[1]] + moveTime);

                if (times[newX][newY] == 0)
                    times[newX][newY] = times[p[0]][p[1]] + moveTime;

                Q.add(new int[]{newX, newY});
            }

            visited[0][0] = true;

        }

        // 결과 출력
        System.out.println(times[X][Y]);
    }
}
