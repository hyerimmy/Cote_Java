

package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06
 * @notes - 에센셜2<br>
 */

public class b1_2775_부녀회장이될테야 {

    public static int[][] apart = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        updateApart();

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine()); //층
            int n = Integer.parseInt(br.readLine()); //호
            System.out.println(apart[k][n]);
        }
    }

    public static void updateApart() {
        // 0층
        for (int b = 1; b <= 14; b++) {
            apart[0][b] = b;
        }

        // 1층~14층
        for (int a = 1; a <= 14; a++) {
            apart[a][1] = 1;
            for (int b = 2; b <= 14; b++) {
                apart[a][b] = apart[a-1][b] + apart[a][b-1];
            }
        }
    }
}

