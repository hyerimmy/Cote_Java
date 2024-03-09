package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.10
 * @notes - DP <br>
 */

public class g4_14002_가장긴증가하는부분수열4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] inputs = new int[N];
        Nlist[] dp = new Nlist[N];
        int maxLengthIdx = 0;

        // 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
//            Random rd = new Random();
//            inputs[i] = rd.nextInt(1000) + 1;
            inputs[i] = Integer.parseInt(st.nextToken());
        }

        // 초기화
        dp[0] = new Nlist(1, inputs[0] + "");

        // dp 탐색
        for (int i = 1; i < N; i++) {
            // 이전 값 중 붙일 수 있는 최대값 구하기
            int maxPrev = -1;
            for (int prev = 0; prev < i; prev++) {
                if ((maxPrev == -1 || dp[prev].length > dp[maxPrev].length) && inputs[prev] < inputs[i]) {
                    maxPrev = prev;
                }
            }

            // 붙여서 dp 배열에 넣기
            if (maxPrev == -1) {
                dp[i] = new Nlist(1, "" + inputs[i]);
            } else {
                dp[i] = new Nlist(dp[maxPrev].length + 1, dp[maxPrev].numbers + " " + inputs[i]);
            }

            // 최대값 갱신
            if (dp[i].length > dp[maxLengthIdx].length) {
                maxLengthIdx = i;
            }

            // 테스트 출력
//            System.out.println(i + " => " + dp[i]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(dp[maxLengthIdx].length).append("\n").append(dp[maxLengthIdx].numbers);
        System.out.println(sb);
    }

    private static class Nlist {
        int length;
        String numbers;

        public Nlist(int length, String numbers) {
            this.length = length;
            this.numbers = numbers;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Nlist{");
            sb.append("length=").append(length);
            sb.append(", numbers='").append(numbers).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}