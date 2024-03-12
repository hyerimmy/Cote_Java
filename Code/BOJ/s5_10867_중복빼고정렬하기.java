package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/
 * @date 2024.03.12
 * @notes - 간단한 실버 문제<br>
 * - 음수를 생각하지 못함!!! -1000 ~ 1000 -> 0~2000
 */

public class s5_10867_중복빼고정렬하기 {
    public static int MAX_SIZE = 1_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        boolean[] existNumber = new boolean[MAX_SIZE * 2 + 1];

        // 중복 없이 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            int number = Integer.parseInt(st.nextToken());
//            Random random = new Random();
//            int number = random.nextInt(1000) + 1;
            existNumber[number + MAX_SIZE] = true;
        }

        // 오름차순 결과 출력하기
        StringBuilder sb = new StringBuilder();
        for (int number = 0; number <= MAX_SIZE * 2; number++) {
            if (existNumber[number])
                sb.append(number - MAX_SIZE).append(" ");
        }
        System.out.println(sb);
    }
}