package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.24
 * @notes - BT 시간초과 간당간당 -> 이분탐색? -> 한번에 성공 <br>
 */

public class g5_2467_용액 {
    public static int N;
    public static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        values = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            values[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(values);

        // 이진탐색
        int left = 0;
        int right = N - 1;
        long minResult = Long.MAX_VALUE;
        StringBuilder resultValues = new StringBuilder();
        while (left < right) {
//            System.out.println(values[left] + " & " + values[right]);
            long result = values[left] + values[right];

            if (Math.abs(result) <= Math.abs(minResult)) {
                minResult = result;
                resultValues = new StringBuilder();
                resultValues.append(values[left]).append(" ").append(values[right]);
            }

            if (result > 0) {
                right--;
            } else if (result < 0) {
                left++;
            } else {
                break;
            }
        }

        // 결과 출력
        System.out.println(resultValues);

    }

}

