package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.22.
 * @notes - 에센셜3 <br>
 * - 발전하려면 알고리즘을 적용시키자. DP 응용 .. 또 어렵네 호~
 */

public class s3_17626_FourSquares_DP {

    public static int N;
    public static int[] dp = new int[50001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;

        for (int n = 3; n <= N; n++) {
            dp[n] = 4;
            for (int k = 1; k * k <= n; k++) {
                dp[n] = Math.min(dp[n], dp[n - k * k] + 1);
            }
        }

        System.out.println(dp[N]);
    }
}