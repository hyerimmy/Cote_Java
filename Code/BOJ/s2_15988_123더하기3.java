package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/15988
 * @date 2024.05.30
 * @notes - <br>
 */

public class s2_15988_123더하기3 {
    public static int MAX_NUMBER = 1_000_000;
    public static long DIV = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        long[] counts = new long[MAX_NUMBER + 1];
        counts[1] = 1;
        counts[2] = 2;
        counts[3] = 4;
        for (int number = 4; number <= MAX_NUMBER; number++) {
            counts[number] = ((counts[number - 1] + counts[number - 2]) % DIV + counts[number - 3]) % DIV;
        }

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            sb.append(counts[number]).append("\n");
        }

        System.out.println(sb);
    }
}

