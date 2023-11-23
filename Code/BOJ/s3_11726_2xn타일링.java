package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.22.
 * @notes - 에센셜3+ <br>
 * - DP 풀 때 조심해야 하는거 : n=1일 때 index out of array 나니까 조심!!
 */

public class s3_11726_2xn타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
        }

        System.out.println(dp[N]);
    }
}