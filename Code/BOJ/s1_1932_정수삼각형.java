package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1932
 * @date 2023.12.11.
 * @notes - DP 응용 문제 <br>
 */

public class s1_1932_정수삼각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 삼각형 값 입력받기
        int[][] values = new int[N][N + 1];
        for (int depth = 0; depth < N; depth++) {
            st = new StringTokenizer(br.readLine());
            for (int idx = 1; idx <= depth + 1; idx++) {
                values[depth][idx] = Integer.parseInt(st.nextToken());
            }
        }

        // DP
        int[][] dp = new int[N][N + 2];
        dp[0][1] = values[0][1];
        for (int depth = 1; depth < N; depth++) {
            for (int idx = 1; idx <= depth + 1; idx++) {
                int maxPrevValue = Math.max(dp[depth - 1][idx], dp[depth - 1][idx - 1]);
                dp[depth][idx] = maxPrevValue + values[depth][idx];
            }
        }

        // 결과 출력
        int result = 0;
        for (int idx = 1; idx <= N; idx++) {
            result = Math.max(result, dp[N-1][idx]);
        }
        System.out.println(result);
    }
}