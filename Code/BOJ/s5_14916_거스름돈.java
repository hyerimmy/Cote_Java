package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/14916
 * @date 2024.04.16
 * @notes - 메모장 없이 풀어보기, 1트 20분, (메모장 없으니까 힘들다.. 연습하기) <br>
 */

public class s5_14916_거스름돈 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer N = Integer.parseInt(st.nextToken());

        // 거스름돈 14 -> 14/5 (2) -> 4(14%5) / 2
        // 13 5+2+2+2+2
        // fiveMaxCount = N / 5
        // * int result = -1;
        // while -> int fiveCount = 0 ~ maxCount
        // {} : N%fiveCount%2 == 0 -> result = N/fiveCount + (N%fiveCount)/2

        int result = -1;

        int fiveMaxCount = N / 5;
        for (int fiveCount = fiveMaxCount; fiveCount >= 0; fiveCount--) {
            int fiveAmount = fiveCount * 5;
            if ((N - fiveAmount) % 2 == 0) { // 2원으로 거스름돈을 채울 수 있다면
                int twoCount = (N - fiveAmount) / 2;
                result = fiveCount + twoCount;
                break;
            }
        }

        // 결과 출력
        System.out.println(result);

    }
}

