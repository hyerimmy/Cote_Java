package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.10.
 * @notes - DP <br>
 */

public class s1_1149_RGB거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 집 수 입력받기
        int N = Integer.parseInt(st.nextToken());

        // 비용 입력받기
        int[][] costs = new int[N + 1][3];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            costs[n][0] = Integer.parseInt(st.nextToken()); // R
            costs[n][1] = Integer.parseInt(st.nextToken()); // G
            costs[n][2] = Integer.parseInt(st.nextToken()); // B
        }

        // DP
        int[][] dp = new int[N + 1][3];
        for (int n = 1; n <= N; n++) {
            dp[n][0] = Math.min(dp[n - 1][1], dp[n - 1][2]) + costs[n][0];
            dp[n][1] = Math.min(dp[n - 1][0], dp[n - 1][2]) + costs[n][1];
            dp[n][2] = Math.min(dp[n - 1][0], dp[n - 1][1]) + costs[n][2];
//            System.out.println(Arrays.toString(dp[n]));
        }

        // 결과 출력
        System.out.println(Math.min(Math.min(dp[N][0], dp[N][1]), dp[N][2]));
    }
}