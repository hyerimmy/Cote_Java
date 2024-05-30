package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2748
 * @date 2024.05.31
 * @notes - <br>
 */

public class b1_2748_피보나치수2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] fibo = new long[91];
        fibo[1] = 1;
        fibo[2] = 1;

        for (int i = 3; i < 91; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

//        System.out.println(Arrays.toString(fibo));
        System.out.println(fibo[n]);
    }
}

