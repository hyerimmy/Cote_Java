
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes - 에센셜2<br>
 */

public class s4_9012_괄호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String inputS = br.readLine();
            int count = 0;
            for (int i = 0; i < inputS.length(); i++) {
                if (inputS.charAt(i) == '(')
                    count++;
                else
                    count--;

                if (count < 0)
                    break;
            }
            if (count == 0)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}

