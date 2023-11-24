package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 * - DP 활용 : 틀림.. <br>
 * - 숫자가 엄청 클 때도 고려하여 max value까지 그냥 싹 계산해버리기
 */

public class s1_1697_숨바꼭질 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int M = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] times = new int[100_001];

        // 수빈 위치 전
        for (int i = 0; i < N; i++) {
            times[i] = N-i;
        }

        // 수빈 위치 후
        for (int i = N + 1; i <= 100_000; i++) {
            // 해당 위치 최소값 업데이트 (2X, X+1)
            times[i] = times[i - 1] + 1;
            if (i % 2 == 0)
                times[i] = Math.min(times[i], times[i / 2] + 1);

            // 해당 위치의 바로 전 위치 최소값 업데이트 (X-1)
            times[i - 1] = Math.min(times[i - 1], times[i] + 1);
        }

        System.out.println(times[M]);

    }
}

