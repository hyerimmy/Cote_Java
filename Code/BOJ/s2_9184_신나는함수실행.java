package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.21.
 * @notes - 재귀 <br>
 */

public class s2_9184_신나는함수실행 {
    public static int[][][] wResults = new int[51][51][51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c)
                    .append(") = ").append(w(a, b, c)).append("\n");
        }

        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if(wResults[a][b][c] != 0)
            return wResults[a][b][c];

        if (a > 20 || b > 20 || c > 20)
            return w(20, 20, 20);

        if (a < b && b < c)
            return wResults[a][b][c] = (w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c));

        return wResults[a][b][c] = (w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1));
    }
}