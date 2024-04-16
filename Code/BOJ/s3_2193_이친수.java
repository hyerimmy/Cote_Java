package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2193
 * @date 2024.04.16
 * @notes - 20분 1트, 메모장 없이<br>
 */

public class s3_2193_이친수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        /*
        N = 3
        101
        100
           [1][ ][ ]
        1 > 1  0  1
        0 > 0  1  1
        -> 1 + 1 = 2

        N = 6 --> 8
        1 00000
        101 000
        101 010
        101 001
        1001 00
        1001 01
        10001 0
        100001

           [1][ ][ ][ ][ ][ ]
        1 > 1  0  1  1  2  3
        0 > 0  1  1  2  3  5
        -> dp[N][0] + dp[N][1]

        -> 1이 들어갈 수 있는 경우 = 앞이 무조건 0
        -> 0이 들어갈 수 있는 경우 = 앞이 0 또는 1 모두
         */

        long[][] dp = new long[91][2];
        dp[1][1] = 1;

        for (int number = 2; number <= N; number++) {
            dp[number][0] = dp[number - 1][0] + dp[number - 1][1];
            dp[number][1] = dp[number - 1][0];
        }

        System.out.println(dp[N][0] + dp[N][1]);

    }
}

