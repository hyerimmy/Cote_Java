package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/13699
 * @date 2024.04.16
 * @notes - 메모장 없이, 17분 1트, (메모장 없는거 진짜 빡세네~ 아오~ )<br>
 */

public class s4_13699_점화식 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 0 1 2 3 4 5
        // t6 = t0*t5 + t1*t4 + t2*t3 + t3*t2 + t4*t1 + t5*t0
        //    = 2 * (t0*t5 + t1*t4 + t2*t3)
        // t0 = 1
        // t1 = t0
        // t2 = t0*t1 + t1*t0
        // t3 = t0*t2 + t1*t1 + t2*t0
        // n * (n-1) = 35*34

        long[] results = new long[36];
        results[0] = 1;
        results[1] = 1;

        for (int n = 2; n <= 35; n++) {
//            System.out.println(n);
            for (int i = 0; i < n / 2; i++) {
//                System.out.println(i + " * " + (n - 1 - i));
                results[n] += 2 * (results[i] * results[n - 1 - i]);
            }
            // 홀수라면
            if (n % 2 == 1) {
                results[n] += (results[n / 2] * results[n / 2]);
            }
        }

//        System.out.println(Arrays.toString(results));

        System.out.println(results[N]);
    }
}

