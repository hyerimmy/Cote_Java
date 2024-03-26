package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.26.
 * @notes - 배낭문제
 */

public class failed_g3_7579_앱 {
    public static long MAX = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N + 1];
        int[] costs = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            memories[n] = Integer.parseInt(st.nextToken());
//            Random rd = new Random();
//            memories[n] = rd.nextInt(10_000_000) + 1;
        }

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            costs[n] = Integer.parseInt(st.nextToken());
//            Random rd = new Random();
//            costs[n] = rd.nextInt(100) + 1;
        }

        long[][] minCosts = new long[N + 1][M + 1];

        for (int t = 1; t <= M; t++) {
            minCosts[0][t] = MAX;
        }

        for (int n = 1; n <= N; n++) {
            minCosts[n][0] = costs[n];

            for (int target = 1; target <= M; target++) {

                // 해당 메모리 선택하는 경우
                int prevMemory = target - memories[n];
                long prevCost = 0;
                if (prevMemory > 0) {
                    prevCost = minCosts[n - 1][prevMemory];
                }

                if (prevCost != MAX)
                    minCosts[n][target] = prevCost + (long) costs[n];
                else
                    minCosts[n][target] = MAX;

                // 해당 메모리 선택하지 않는 경우
                minCosts[n][target] = Math.min(minCosts[n][target], minCosts[n - 1][target]);
            }
        }

        System.out.println(minCosts[N][M]);
    }

}
