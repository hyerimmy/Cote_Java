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
 * - 메모리초과,, String 배열 대신.. 어떻게 할까 -> int로 처리한 다음에 나중에 다시 거슬러 올라가 결과 찾는 것으로!
 */

public class g4_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        // 2차원 DP
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 결과 출력
        StringBuilder result = new StringBuilder();
        result.append(dp[s1.length()][s2.length()]);
        if (dp[s1.length()][s2.length()] > 0) {
            result.append("\n");

            Stack<Character> S = new Stack<>();
            int i = s1.length();
            int j = s2.length();
            while (i > 0 && j > 0) {
                if (dp[i][j] == dp[i - 1][j]) {
                    i -= 1;
                } else if (dp[i][j] == dp[i][j - 1]) {
                    j -= 1;
                } else {
                    i -= 1;
                    j -= 1;
                    S.push(s1.charAt(i));
                }
            }

            while (!S.isEmpty()) {
                result.append(S.pop());
            }
        }
        System.out.println(result);
    }
}

/*
ALALALA
LALALA
*/