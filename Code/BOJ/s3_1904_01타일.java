package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1904
 * @date 2024.05.27
 * @notes - <br>
 * 0 0 1 1
 * 0 0 0 0
 * 1 0 0 1
 * 1 1 0 0
 * 1 1 1 1
 * 두번째 0을 넣는 경우 - 0 1 1 2
 * 1을 넣는 경우      - 1 1 2 3
 * 두번째 0을 넣는 경우 = 0넣는경우[-2] + 1넣는경우[-2]
 * 1을 넣는 경우 = 0넣는경우[-1] + 1넣는경우[-1]
 */

public class s3_1904_01타일 {
    public static int DIV_NUM = 15746;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] dp = new int[2][1_000_000 + 1];

        dp[0][1] = 0;
        dp[1][1] = 1;
        dp[0][2] = 1;
        dp[1][2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[0][i] = (dp[0][i - 2] + dp[1][i - 2]) % DIV_NUM;
            dp[1][i] = (dp[0][i - 1] + dp[1][i - 1]) % DIV_NUM;
        }

//        System.out.println(Arrays.toString(dp[0]));
//        System.out.println(Arrays.toString(dp[1]));

        System.out.println((dp[0][N] + dp[1][N]) % DIV_NUM);
    }
}

