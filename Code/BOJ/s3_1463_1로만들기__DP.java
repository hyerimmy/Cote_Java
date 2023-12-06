package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.22.
 * @notes - 에센셜3 <br>
 * - 발전하려면 알고리즘을 적용시키자. DP 적용시키는 연습 제발하자
 */

public class s3_1463_1로만들기__DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] d = new int[N + 1];
        d[0] = 0;
        d[1] = 0;
        for (int i = 2; i <= N; i++) {
            d[i] = d[i - 1] + 1; // 3. 1 뺀다
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1); // 1. 3 나눈다
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1); // 2. 2 나눈다
        }
        System.out.println(d[N]);

    }
}