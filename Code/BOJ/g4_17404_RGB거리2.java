package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.05
 * @notes - DP
 */

public class g4_17404_RGB거리2 {
    public static int INF = Integer.MAX_VALUE;

    public static int R = 0;
    public static int G = 1;
    public static int B = 2;

    public static int N;
    public static int[][] cost;


    public static int[][] dp;
    public static int minCost = INF;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N 입력받기
        N = Integer.parseInt(st.nextToken());

        cost = new int[N][3];
        dp = new int[N][3];

        // 비용 입력받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            cost[n][R] = Integer.parseInt(st.nextToken());
            cost[n][G] = Integer.parseInt(st.nextToken());
            cost[n][B] = Integer.parseInt(st.nextToken());
        }

        // 비용 계산하기
        for (int startColor : new int[]{R, G, B}) {
//            System.out.println(startColor);

            // dp 초기화
            dp[0][R] = startColor == R ? cost[0][R] : INF;
            dp[0][G] = startColor == G ? cost[0][G] : INF;
            dp[0][B] = startColor == B ? cost[0][B] : INF;
//            System.out.println(0 + " => " + Arrays.toString(dp[0]));

            // dp 탐색
            for (int i = 1; i < N; i++) {
                for (int color : new int[]{R, G, B}) {
                    int prevMinValue = getMinDpValue(i - 1, color);
                    dp[i][color] = prevMinValue == INF ? INF : prevMinValue + cost[i][color];
                }
//                System.out.println(i + " => " + Arrays.toString(dp[i]));
            }

            // 최소비용 업데이트
            minCost = Math.min(minCost, getMinDpValue(N - 1, startColor));
        }

        // 결과 출력
        System.out.println(minCost);
    }

    private static int getMinDpValue(int index, int exceptColor) {
        int minValue = INF;
        for (int color : new int[]{R, G, B}) {
            if (color != exceptColor && minValue > dp[index][color]) {
                minValue = dp[index][color];
            }
        }
        return minValue;
    }
}