package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1475
 * @date 2024.05.29
 * @notes - <br>
 */

public class s5_1475_방번호 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] numberCount = new int[10];

        while (N > 0) {
            int number = N % 10;
            numberCount[number]++;
            N /= 10;
        }

        // 6은 9로 사용할 수 있다.
        int calculateCount = (int) Math.ceil((numberCount[6] + numberCount[9]) / (double) 2);
        numberCount[6] = calculateCount;
        numberCount[9] = calculateCount;

//        System.out.println(Arrays.toString(numberCount));

        // 필요한 세트 개수 계산
        int needCount = 0;
        for (int number = 0; number <= 9; number++) {
            needCount = Math.max(needCount, numberCount[number]);
        }

        // 결과 출력
        System.out.println(needCount);
    }
}

