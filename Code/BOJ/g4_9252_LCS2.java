package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.26 - 2024.02.27
 * @notes - 1%에서 틀림 ㅎ <br/>
 * - 2차원DP 활용 문제!! 기억하자. <br/>
 * - (1) s1[i] == s2[j] -> dp[i][j] = dp[i-1][j-1] + 1 <br/>
 * - (2) s1[i] != s2[j] -> dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) <br/>
 */

public class g4_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = "";
        }
        for (int j = 0; j <= s2.length(); j++) {
            dp[0][j] = "";
        }

        // 2차원 DP
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    if (dp[i - 1][j].length() >= dp[i][j - 1].length())
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // 결과 출력
        System.out.println(dp[s1.length()][s2.length()].length());
        if (dp[s1.length()][s2.length()].length() > 0)
            System.out.println(dp[s1.length()][s2.length()]);
    }
}

/*
ALALALA
LALALA
*/