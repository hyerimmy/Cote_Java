package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.19
 * @notes - 수학
 */

public class g4_13172_시그마 {
    public static long X = 1_000_000_007;
//    public static long X = 11;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            long b = Integer.parseInt(st.nextToken());
            long a = Integer.parseInt(st.nextToken());

            long calculatedB = calculateModuler(b, X - 2);
            result = (result + calculatedB * a % X) % X;
        }

        System.out.println(result);

    }

    public static long calculateModuler(long number, long count) {
        if (count == 1)
            return number;

        long tempResult = calculateModuler(number, count / 2);
        if (count % 2 == 0) {
            return tempResult * tempResult % X;
        } else {
            return tempResult * tempResult % X * number % X;
        }
    }
}