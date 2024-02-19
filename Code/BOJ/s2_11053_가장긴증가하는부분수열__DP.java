package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 에센셜4 <br>
 */

public class s2_11053_가장긴증가하는부분수열__DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N + 1];
        int[] counts = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        int maxCount = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                if (numbers[i] > numbers[j])
                    counts[i] = Math.max(counts[i], counts[j] + 1);
            }
            maxCount = Math.max(maxCount, counts[i]);
        }
//        System.out.println(Arrays.toString(counts));

        System.out.println(maxCount);
    }
}