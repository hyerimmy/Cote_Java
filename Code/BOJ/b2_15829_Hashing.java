
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.08.
 * @notes - 에센셜2++<br>
 * - 범위가 크면 int형이 아니라 long형으로 정의할 것.
 * - 수가 정의한 범위를 넘어서면 -로 바뀜. 무조건 나머지연산 모든 연산에 넣을 것!!!!
 */

public class b2_15829_Hashing {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine()); // 문자열 길이
        String S = br.readLine(); // 문자열

        long answer = 0;

        long r = 1;
        for (int i = 0; i < L; i++) {
            long hash = (S.charAt(i) - 'a' + 1) * r % 1234567891;
            r = r * 31 % 1234567891;
            answer = (answer + hash) % 1234567891;
        }
        System.out.println(answer);
    }
}

