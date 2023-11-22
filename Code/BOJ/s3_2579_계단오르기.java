package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.22.
 * @notes - 에센셜3 <br>
 * - 발전하려면 알고리즘을 적용시키자. DP 응용 굳히기
 */

public class s3_2579_계단오르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[N+1];
        for(int i=1; i<=N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = stair[1];
        dp[2] = dp[1] + stair[2];
        dp[3] = Math.max(stair[1], stair[2]) + stair[3];
        for(int i=4; i<=N; i++){
            dp[i] = Math.max(stair[i - 1] + dp[i - 3], dp[i - 2]) + stair[i];
        }
        System.out.println(dp[N]);
    }
}