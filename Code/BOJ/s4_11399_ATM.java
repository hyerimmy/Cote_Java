package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.22.
 * @notes - 에센셜3+ <br>
 */

public class s4_11399_ATM {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] time = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }

        int timeSum = 0;
        Arrays.sort(time);
        for (int i = 0; i < N; i++) {
            timeSum += (time[i] * (N - i));
        }

        System.out.println(timeSum);
    }
}