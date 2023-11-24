package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 */

public class s1_14940_쉬운최단거리 {
    public static int N; // 세로
    public static int M; // 가로
    public static int[][] count;
    public static boolean[][] visited;

    public static int[] dx = new int[]{1, 0, -1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        count = new int[N][M];
        visited = new boolean[N][M];

        int targetN = 0;
        int targetM = 0;

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 2) {
                    targetN = n;
                    targetM = m;
                }
                if (type == 0) {
                    visited[n][m] = true;
                }
            }
        }

        setCount(targetN, targetM);

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                int countN = -1;
                if(visited[n][m])
                    countN = count[n][m];
                sb.append(countN).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void setCount(int startN, int startM) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{startN, startM});
        visited[startN][startM] = true;

        while (!Q.isEmpty()) {
            int[] p = Q.poll();
            int n = p[0];
            int m = p[1];

            for (int t = 0; t < 4; t++) {
                int newN = n + dx[t];
                int newM = m + dy[t];
                if (newN >= 0 && newN < N && newM >= 0 && newM < M && !visited[newN][newM]) {
                    visited[newN][newM] = true;
                    count[newN][newM] = count[n][m] + 1;
                    Q.add(new int[]{newN, newM});
                }
            }
        }
    }
}

