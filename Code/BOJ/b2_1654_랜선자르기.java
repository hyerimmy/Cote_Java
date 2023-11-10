package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2++ <br>
 * - 이진탐색문제!! <br>
 * - 좀.. 이해 안됨.. 왜 마지막에 unit 출력하는게 아니라 (end + start) / 2 일까..?
 */

public class b2_1654_랜선자르기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 랜선 수
        int N = Integer.parseInt(st.nextToken()); // 목료 랜선 수

        long[] L = new long[K];
        long maxLength = 0;
        for (int i = 0; i < K; i++) {
            L[i] = Integer.parseInt(br.readLine());
            maxLength = Math.max(L[i], maxLength);
        }

        long start = 1;
        long end = maxLength;
        while (start <= end) {
            long unit = (end + start) / 2;
            long count = 0;
            for (long l : L) {
                count += l / unit;
            }
            if (count >= N) {
                start = unit + 1;
            }
            if (count < N) {
                end = unit - 1;
            }
        }

        System.out.println((end + start) / 2);
    }
}