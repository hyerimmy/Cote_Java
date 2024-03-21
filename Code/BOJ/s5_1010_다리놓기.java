package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.03.21
 * @notes - 다리 놓기 <br>
 */

public class s5_1010_다리놓기 {
    public static int MAX = 30;
    public static int[][] combinations = new int[MAX + 1][MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // combination 계산식
        for (int a = 1; a <= MAX; a++) {
            combinations[a][1] = a;
            for (int b = 2; b <= a; b++) {
                combinations[a][b] = combinations[a][b - 1] * (a + 1 - b) / b;
            }
//            System.out.println(a + " -> " + Arrays.toString(combinations[a]));
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // M C N
            sb.append(combinations[M][N]).append("\n");
        }

        // 결과 출력
        System.out.println(sb);
    }
}

