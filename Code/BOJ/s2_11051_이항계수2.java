package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.04.01
 * @notes -  <br>
 */

public class s2_11051_이항계수2 {
    public static int DIV = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] results = new long[K + 1];
        results[0] = 1;
        for (int k = 1; k <= K; k++) {
            results[k] = results[k - 1] * (N - k + 1) % DIV * calculatePow(k, DIV - 2) % DIV;
        }

//        System.out.println(Arrays.toString(results));
        System.out.println(results[K]);
    }

    private static int calculatePow(int a, int b) {
        if (b == 1) {
            return a;
        }

        int resut = calculatePow(a, b / 2);
        if (b % 2 == 0) {
            return (int) ((long) resut * resut % DIV);
        }
        return (int) ((long) resut * resut % DIV * a % DIV);
    }
}

// 4000000 3999999