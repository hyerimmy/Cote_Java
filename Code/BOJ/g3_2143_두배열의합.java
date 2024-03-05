package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.05.
 * @notes - 구현?
 */

public class g3_2143_두배열의합 {
    public static void main(String[] args) throws IOException {

        int T, N, M;
        long result = 0;
        int[] sum1, sum2; // 누적합
        HashMap<Integer, Integer> counter1 = new HashMap<>();
        HashMap<Integer, Integer> counter2 = new HashMap<>();

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        sum1 = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            sum1[n] = sum1[n - 1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        sum2 = new int[M + 1];

        st = new StringTokenizer(br.readLine());
        for (int m = 1; m <= M; m++) {
            sum2[m] = sum2[m - 1] + Integer.parseInt(st.nextToken());
        }

        // 카운팅하기
        for (int end = 1; end <= N; end++) {
            for (int start = 0; start < end; start++) {
                counter1.put(sum1[end] - sum1[start], counter1.getOrDefault(sum1[end] - sum1[start], 0) + 1);
            }
        }

        for (int end = 1; end <= M; end++) {
            for (int start = 0; start < end; start++) {
                counter2.put(sum2[end] - sum2[start], counter2.getOrDefault(sum2[end] - sum2[start], 0) + 1);
            }
        }

        // 정답 카운팅
        for (int n1 : counter1.keySet()) {
            int n2 = T - n1;
            if (counter2.containsKey(n2)) {
                result += (long) counter1.get(n1) * counter2.get(n2);
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}