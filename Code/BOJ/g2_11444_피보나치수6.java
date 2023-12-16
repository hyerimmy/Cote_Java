package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.16.
 * @notes - 에센셜4+ <br>
 * - F(a+b) = F(a-1) * F(b) + F(a) * F(b+1) <br>
 * - F(2n) = F(n) * (2 * F(n-1) + F(n)) <br>
 * - F(2n + 1) = F(n) * F(n) + F(n + 1) * F(n + 1) <br>
 */

public class g2_11444_피보나치수6 {
    public static int DIVIDE_NUM = 1_000_000_007;
    public static HashMap<Long, Long> fiboResult = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        System.out.println(fibo(N));
    }

    public static long fibo(long n) {
        if (n < 2)
            return n;

        if (!fiboResult.containsKey(n)) {
            if (n % 2 == 0) {
                long result1 = fibo(n / 2);
                long result2 = fibo(n / 2 - 1);
                fiboResult.put(n, (result1 * ((2 * result2) % DIVIDE_NUM + result1) % DIVIDE_NUM) % DIVIDE_NUM);
            } else {
                long result1 = fibo(n / 2);
                long result2 = fibo(n / 2 + 1);
                fiboResult.put(n, ((result1 * result1) % DIVIDE_NUM + (result2 * result2) % DIVIDE_NUM) % DIVIDE_NUM);
            }
        }

        return fiboResult.get(n);
    }
}