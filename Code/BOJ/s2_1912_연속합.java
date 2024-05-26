package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1912
 * @date 2024.05.26
 * @notes - <br>
 * [0] 10 6 9 10 15 21 -14 -2 19 18
 * 선택O -> max(선택O+num, num)
 * 선택O - [0] 10 6 9 10 15 21 -14 12 33 32
 */

public class s2_1912_연속합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N + 1];
        int maxNumber = -1001;
        for (int i = 1; i <= N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            maxNumber = Math.max(maxNumber, numbers[i]);
        }

        int maxSum = maxNumber;
        int[] sum = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            sum[i] = Math.max(sum[i - 1] + numbers[i], numbers[i]);
            maxSum = Math.max(maxSum, sum[i]);
        }

        System.out.println(maxSum);
    }
}

