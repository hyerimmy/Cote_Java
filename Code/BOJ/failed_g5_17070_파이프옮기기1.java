package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/17070
 * @date 2024.02.16.
 * @notes - 노트 꺼내기 싫어서 주석으로 알고리즘을 설계해봤는데 굉장히 비효율적~ <br>
 */

public class failed_g5_17070_파이프옮기기1 {
    public static int N;
    public static boolean[][] isEmpty;
    public static boolean[][] visited;
    public static int[][][] dp;

    public static int RIGHT = 0;
    public static int DOWN = 1;
    public static int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isEmpty = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    isEmpty[row][col] = true;
                } else {
                    visited[row][col] = true; // 벽 방문처리
                }

                if (col <= 1 || row <= 1) {
                    visited[row][col] = true; // 접근 불가능한 곳 방문처리
                }
            }
        }

        // dp 초기화
        dp[1][2][RIGHT] = 1;
        visited[1][1] = true;
        visited[1][2] = true;

        // BFS + DP탐색
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{1 + 1, 2});
        Q.add(new int[]{1, 2 + 1});
        Q.add(new int[]{1 + 1, 2 + 1});
        while (!Q.isEmpty()) {
            int[] P = Q.poll();
            int row = P[0];
            int col = P[1];

            // 범위를 벗어난다면 건너뛰기
            if (row > N || col > N)
                continue;

            // 아직 계산을 처리하지 않았고 벽이 아니라면 DP 처리
            if (!visited[row][col] && isEmpty[row][col]) {
                System.out.println("* -> " + Arrays.toString(P));
                setCountNumber(row, col);
                Q.add(new int[]{row + 1, col});
                Q.add(new int[]{row, col + 1});
                Q.add(new int[]{row + 1, col + 1});
            }
        }

        for (int row = 1; row <= N; row++) {
            for (int col = 1; col <= N; col++) {
                System.out.print("(" + dp[row][col][RIGHT] + ", " + dp[row][col][DOWN] + ", " + dp[row][col][DIAGONAL] + ")");
            }
            System.out.println();
        }

        // 결과 출력
        System.out.println(dp[N][N][RIGHT] + dp[N][N][DOWN] + dp[N][N][DIAGONAL]);
    }

    private static void setCountNumber(int row, int col) {
        // 이전 칸의 계산이 완료되지 않았다면 처리하지 않는다.
        if (!visited[row - 1][col] || !visited[row][col - 1] || !visited[row - 1][col - 1])
            return;

        // 이전 칸에서 올 수 있는 개수를 더한다.
        dp[row][col][RIGHT] = dp[row][col - 1][RIGHT];
//        if (row + 1 <= N && isEmpty[row + 1][col])
        dp[row][col][RIGHT] += dp[row][col - 1][DIAGONAL];

        dp[row][col][DOWN] = dp[row - 1][col][DOWN];
//        if (col + 1 <= N && isEmpty[row][col + 1])
        dp[row][col][DOWN] += dp[row - 1][col][DIAGONAL];

        dp[row][col][DIAGONAL] = dp[row - 1][col - 1][DIAGONAL];
//        if (col - 1 >= 1 && isEmpty[row][col - 1])
        dp[row][col][DIAGONAL] += dp[row - 1][col - 1][DOWN];
//        if (row - 1 >= 1 && isEmpty[row - 1][col])
        dp[row][col][DIAGONAL] += dp[row - 1][col - 1][RIGHT];

        // 방문처리한다.
        visited[row][col] = true;
    }
}

