package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2914
 * @date 2024.05.17
 * @notes - <br>
 */

public class b3_2914_저작권 {
    /*
    23 (I -1) < 894 (N) / 38 (A) <= 24 (I)
    (I-1)*A < N <= I*A
    23*38 < N <= 24*38
    => N = (I-1) * A + 1
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int I = Integer.parseInt(st.nextToken());

        int N = (I - 1) * A + 1;
        System.out.println(N);
    }
}

