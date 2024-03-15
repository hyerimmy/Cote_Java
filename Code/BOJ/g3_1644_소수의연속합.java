package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.15
 * @notes - 한 번에 풀었지롱~ <br>
 */

public class g3_1644_소수의연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 소수 계산
        boolean[] isSosu = new boolean[Math.max(N + 1, 2)];
        Arrays.fill(isSosu, true);
        isSosu[0] = false;
        isSosu[1] = false;
        for (int n = 2; n <= Math.sqrt(N); n++) {
            int k = 2;
            while (n * k <= N) {
                isSosu[n * k] = false;
                k++;
            }
        }
//        System.out.println(Arrays.toString(isSosu));

        // 누적합
        List<Integer> sums = new ArrayList<>();
        sums.add(0);
        for (int n = 1; n <= N; n++) {
            if (isSosu[n])
                sums.add(sums.get(sums.size() - 1) + n);
        }
//        System.out.println(sums);

        // 투포인터 탐색
        int answer = 0;
        int left = 0;
        int right = 0;
        while (left <= right && right < sums.size()) {
            int value = sums.get(right) - sums.get(left);
            if (value < N) {
                right++;
            }
            if (value > N) {
                left++;
            }
            if (value == N) {
                answer++;
                right++;
            }
        }


        // 결과 출력
        System.out.println(answer);

    }
}