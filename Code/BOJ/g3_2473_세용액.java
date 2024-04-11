package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2473
 * @date 2024.04.11
 * @notes - 1트만에 성공!!!! 호레잉~~ 57분! <br>
 */

public class g3_2473_세용액 {
    public static int MAX_VALUE = 1_000_000_000;
    public static int MIN_VALUE = -1_000_000_000;

    public static int N;
    public static int[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        values = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
//            Random rd = new Random();
//            values[n] = rd.nextInt(MAX_VALUE) + 1;
            values[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(values);

        // 결과 저장 변수
        long resultSum = Long.MAX_VALUE;
        int[] resultValues = new int[3];

        for (int a = 0; a < N; a++) {
            for (int b = a + 1; b < N; b++) {
                // 2개 합 구하기 (12,500,000)
                long sum = values[a] + values[b];

                // 만약 어떤 수를 더하더라도 결과를 갱신할 수 없다면 건너뛰기
                if (sum + MAX_VALUE > resultSum && sum + MIN_VALUE > resultSum) {
                    continue;
                }

                // 더 선택할 수가 없다면 건너뛰기
                if (b + 1 >= N) {
                    continue;
                }

                // 이분탐색 통해서 나머지 1개 최적의 수 선택
                int c = selectIdx(sum, b + 1);
                sum += values[c];
                sum = Math.abs(sum);

//                System.out.println();
//                System.out.println("a : " + values[a]);
//                System.out.println("b : " + values[b]);
//                System.out.println("c : " + values[c]);

                // 결과 갱신
                if (resultSum > sum) {
                    resultSum = sum;
                    resultValues = new int[]{values[a], values[b], values[c]};
                }
            }
        }

        // 결과 출력
        System.out.println(resultValues[0] + " " + resultValues[1] + " " + resultValues[2]);

        br.close();
    }

    private static int selectIdx(long sum, int startIdx) {
        int left = startIdx;
        int right = N - 1;

        int resultIdx = (left + right) / 2;
        long resultTotalSum = values[resultIdx] + sum;

        while (left <= right) {
            int mid = (left + right) / 2;
            long totalSum = values[mid] + sum;

            if (Math.abs(resultTotalSum) > Math.abs(totalSum)) {
                resultIdx = mid;
                resultTotalSum = totalSum;
            }

            if (totalSum < 0) {
                left = mid + 1;
                continue;
            }
            if (totalSum > 0) {
                right = mid - 1;
                continue;
            }

            break;
        }

        return resultIdx;
    }
}

