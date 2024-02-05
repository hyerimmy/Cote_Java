package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.05.
 * @notes
 */


public class s1_14888_연산자끼워넣기 {
    public static int N;
    public static int[] numbers;
    public static int[] calculateCount = new int[4];
    public static int MAX = 1_000_000_000;
    public static int minValue = MAX;
    public static int maxValue = -1 * MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        // 숫자 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int c = 0; c < 4; c++) {
            calculateCount[c] = Integer.parseInt(st.nextToken());
        }

        // 브루트포스
        calculateNumber(1, numbers[0]);

        // 결과 출력
        System.out.println(maxValue);
        System.out.println(minValue);
    }

    private static void calculateNumber(int index, int result) {
        // 마지막까지 연산이 끝났다면 결과값 갱신하고 종료
        if (index == N) {
            maxValue = Math.max(maxValue, result);
            minValue = Math.min(minValue, result);
            return;
        }

        // 4가지 연산 진행
        for (int c = 0; c < 4; c++) {
            if (calculateCount[c] > 0) {
                calculateCount[c]--;
                if (c == 0) // +
                    calculateNumber(index + 1, result + numbers[index]);
                if (c == 1) // -
                    calculateNumber(index + 1, result - numbers[index]);
                if (c == 2) // x
                    calculateNumber(index + 1, result * numbers[index]);
                if (c == 3) // ÷
                    calculateNumber(index + 1, result / numbers[index]);
                calculateCount[c]++;
            }
        }
    }
}