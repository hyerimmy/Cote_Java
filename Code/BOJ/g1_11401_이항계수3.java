package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.28
 * @notes -  <br>
 */

/*
6C0 = 1
6C1 = 6/1 = 1*(6-1+1)/1 = 6
6C2 = 6*5/2*1 = 6C1 * 5/2 = 6C1 * (6-2+1)/2
6C3 = 6*5*4/3*2*1 = 6C2 * 4/3 = 6C2 * (6-3+1)/3
nCk = nC(k-1) * (n-k+1)/k
 */
public class g1_11401_이항계수3 {
    public static int DIV = 1_000_000_007;

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