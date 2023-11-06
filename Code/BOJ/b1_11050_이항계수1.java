package BOJ;

import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes
 * - 에센셜2+ <br>
 */

public class b1_11050_이항계수1 {

    static int[] factorialResult;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        factorialResult = new int[N + 1];
        setFactorial(N);

        System.out.println(factorialResult[N] / factorialResult[N - K] / factorialResult[K]);
    }

    public static void setFactorial(int n) {
        factorialResult[0] = 1;
        factorialResult[1] = 1;
        for (int i = 2; i <= n; i++) {
            factorialResult[i] = factorialResult[i - 1] * i;
        }
    }
}