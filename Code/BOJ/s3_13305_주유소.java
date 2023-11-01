package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.01
 * @notes - 현대 기출<br>
 */

public class s3_13305_주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시수

        int[] distanceA = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distanceA[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        long minPrice = -1;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1; i++) {
            long currentPrice = Integer.parseInt(st.nextToken());
            if (minPrice == -1 || currentPrice < minPrice)
                minPrice = currentPrice;
            answer += minPrice * distanceA[i];
        }

        System.out.println(answer);
    }
}

