package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.05
 * @notes - 에센셜4<br>
 * - DP 풀이 <br>
 * - 또! DP에서 맨날 틀리는 array index error! 1~2정도의 적은 수가 들어올 경우 대비해서 dp 크기 그냥 최대로 만들기!
 */

public class s1_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] scores = new int[2][N + 1];
            int[][] dp = new int[2][N + 1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    scores[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // dp 초기화
            for (int i = 0; i < 2; i++) {
                for (int j = 1; j <= 2; j++) {
                    dp[i][j] = scores[i][j] + scores[1-i][j-1];
                }
            }

            // dp 탐색
            for (int j = 3; j <= N; j++) {
                for (int i = 0; i < 2; i++) {
                    dp[i][j] = scores[i][j] + Math.max(dp[1-i][j-1], dp[1-i][j-2]);
                }
            }

//            System.out.println(Arrays.toString(dp[0]));
//            System.out.println(Arrays.toString(dp[1]));

            sb.append(Math.max(dp[0][N], dp[1][N])).append("\n");
        }

        System.out.println(sb);

    }
}

