package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem/1932
 * @date 2023.12.11.
 * @notes - DP, 2차원이라 어려웠다! 정복하자  <br>
 * - 2차원DP 활용 문제!! 기억하자. <br/>
 * - (1) s1[i] == s2[j] -> dp[i][j] = dp[i-1][j-1] + 1 <br/>
 * - (2) s1[i] != s2[j] -> dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) <br/>
 */

public class g5_9251_LCS__2차원DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] string1 = br.readLine().toCharArray();
        char[] string2 = br.readLine().toCharArray();

        int[][] dp = new int[string2.length + 1][string1.length + 1];

        for (int s1 = 0; s1 < string1.length; s1++) {
            for (int s2 = 0; s2 < string2.length; s2++) {
                dp[s2 + 1][s1 + 1] = Math.max(dp[s2 + 1][s1], dp[s2][s1 + 1]);
                if (string1[s1] == string2[s2])
                    dp[s2 + 1][s1 + 1] = Math.max(dp[s2 + 1][s1 + 1], dp[s2][s1] + 1);
            }
        }

        System.out.println(dp[string2.length][string1.length]);

    }

}