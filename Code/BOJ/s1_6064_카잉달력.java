package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.01
 * @notes
 */

public class s1_6064_카잉달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int result = -1;
            int k = 0;
            int maxY = N - (M - x) <= 0 ? N - (M - x) + N : N - (M - x);
            while (M * k + x <= M*N) {
                int cnt = M * k + x;
                int targetY = cnt % N != 0 ? cnt % N : N;
                if (y == targetY) {
                    result = cnt;
                    break;
                }
                if (targetY == maxY)
                    break;
                k++;
            }
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
