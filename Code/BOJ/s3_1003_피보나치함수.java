package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.11.
 * @notes - 에센셜3 <br>
 */

public class s3_1003_피보나치함수 {
    static int[][] fiboResult = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fibonacci(40);

        int T = Integer.parseInt(br.readLine()); // 테스트 개수
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int input = Integer.parseInt(br.readLine());
            sb.append(fiboResult[input][0]).append(" ").append(fiboResult[input][1]).append("\n");
        }

        System.out.println(sb);
    }

    public static void fibonacci(int max) {
        fiboResult[0] = new int[]{1, 0};
        fiboResult[1] = new int[]{0, 1};
        for(int n=2; n<=max; n++){
            fiboResult[n][0] = fiboResult[n-1][0] + fiboResult[n-2][0];
            fiboResult[n][1] = fiboResult[n-1][1] + fiboResult[n-2][1];
        }
    }

}