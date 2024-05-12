package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/12738
 * @date 2024.05.13
 * @notes - <br>
 */

public class failed_g2_12738_가장긴증가하는부분수열3 {

    public static int[] numbers;
    public static int[] upCounts;
    public static int[] downCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        upCounts = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            numbers[n] = Integer.parseInt(st.nextToken());
        }

        // 상승과 하위 수열 개수 카운팅 (DP)
        for (int middle = 0; middle < N; middle++) {
            // upCounts
            for (int arround = 0; arround < middle; arround++) {
                if (numbers[arround] < numbers[middle])
                    upCounts[middle] = Math.max(upCounts[middle], upCounts[arround] + 1);
            }
        }

        int result = 0;
        for (int n = 0; n < N; n++) {
            result = Math.max(result, upCounts[n]);
        }

        System.out.println(result + 1);

    }
}

