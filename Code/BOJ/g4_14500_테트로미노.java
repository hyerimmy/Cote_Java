package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.03.
 * @notes - 에센셜3++<br>
 */

public class g4_14500_테트로미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] value = new int[N + 1][M + 1];
        int[][] sum = new int[N + 1][M + 1];
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 1; m <= M; m++) {
                value[n][m] = Integer.parseInt(st.nextToken());
                sum[n][m] = value[n][m] + sum[n - 1][m] + sum[n][m - 1] - sum[n - 1][m - 1];
            }
        }

        int sumMax = 0;


        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                // 1. 일직선 사각형 모양 (1가지)
                if (n >= 4) {
                    sumMax = Math.max(sumMax, sum[n][m] - sum[n - 4][m] - sum[n][m - 1] + sum[n - 4][m - 1]);
                }
                if (m >= 4) {
                    sumMax = Math.max(sumMax, sum[n][m] - sum[n][m - 4] - sum[n - 1][m] + sum[n - 1][m - 4]);
                }

                // 2. 정사각형 모양 (1가지)
                if (n >= 2 && m >= 2) {
                    sumMax = Math.max(sumMax, sum[n][m] - sum[n - 2][m] - sum[n][m - 2] + sum[n - 2][m - 2]);
                }


                // 3. 나머지 6칸 영역의 모양 (3가지)
                if (n >= 3 && m >= 2) {
                    sumMax = Math.max(sumMax, getMaxValueBasedSix(
                            value[n - 2][m - 1], value[n - 1][m - 1], value[n][m - 1],
                            value[n - 2][m], value[n - 1][m], value[n][m]
                    ));
                }
                if (n >= 2 && m >= 3) {
                    sumMax = Math.max(sumMax, getMaxValueBasedSix(
                            value[n - 1][m - 2], value[n - 1][m - 1], value[n - 1][m],
                            value[n][m - 2], value[n][m - 1], value[n][m]
                    ));
                }
            }
        }

        System.out.println(sumMax);
    }

    /*
    a d
    b e
    c f
     */
    public static int getMaxValueBasedSix(int a, int b, int c, int d, int e, int f) {
        int maxValue = 0;
        int sixSum = a + b + c + d + e + f;
        maxValue = Math.max(maxValue, sixSum - a - b);
        maxValue = Math.max(maxValue, sixSum - a - c);
        maxValue = Math.max(maxValue, sixSum - b - c);
        maxValue = Math.max(maxValue, sixSum - d - e);
        maxValue = Math.max(maxValue, sixSum - d - f);
        maxValue = Math.max(maxValue, sixSum - e - f);
        maxValue = Math.max(maxValue, sixSum - a - f);
        maxValue = Math.max(maxValue, sixSum - c - d);
        return maxValue;
    }
}