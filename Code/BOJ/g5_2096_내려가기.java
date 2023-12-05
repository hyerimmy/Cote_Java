package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.05
 * @notes - 에센셜4 <br>
 */

public class g5_2096_내려가기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] max = new int[100001][3];
        int[][] min = new int[100001][3];

        for (int n = 1; n <= N; n++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k = 0; k < 3; k++) {
                int score = Integer.parseInt(st.nextToken());

                int prevMaxScore = max[n - 1][k];
                int prevMinScore = min[n - 1][k];

                if (k + 1 <= 2) {
                    prevMaxScore = Math.max(prevMaxScore, max[n - 1][k + 1]);
                    prevMinScore = Math.min(prevMinScore, min[n - 1][k + 1]);
                }
                if (k - 1 >= 0) {
                    prevMaxScore = Math.max(prevMaxScore, max[n - 1][k - 1]);
                    prevMinScore = Math.min(prevMinScore, min[n - 1][k - 1]);
                }

                max[n][k] = prevMaxScore + score;
                min[n][k] = prevMinScore + score;
            }
//            System.out.println("max : " + Arrays.toString(max[n]));
//            System.out.println("min : " + Arrays.toString(min[n]));
//            System.out.println();
        }

        ;
        System.out.println(Math.max(Math.max(max[N][0], max[N][1]), max[N][2]));
        System.out.println(Math.min(Math.min(min[N][0], min[N][1]), min[N][2]));
    }
}