package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.10.
 * @notes - 분할정복을 활용한 거듭제곱! <br>
 * - A^4 = (A^2)^2 (짝수일때) <br>
 * - A^5 = A * A^4 = A * (A^2)^2 (홀수일때) <br>
 */

public class g4_10830_행렬제곱__분할정복거듭제곱 {
    public static int N;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행렬 크기
        long B = Long.parseLong(st.nextToken()); // 지수

        arr = new int[N][N]; // 행렬

        // 행렬 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        // 행렬 곱
        int[][] result = power(B);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] power(long up) {
        if (up == 1)
            return arr;

        int[][] temp = power(up / 2);

        if (up % 2 != 0)
            return calculate(calculate(temp, temp), arr);
        return calculate(temp, temp);
    }

    public static int[][] calculate(int[][] A, int[][] B) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] = (result[i][j] + (A[i][k] * B[k][j]) % 1000) % 1000;
                }
            }
        }
        return result;
    }
}