package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜4+ <br>
 * - DP문제, 가장긴~수열 과 같은 형태의 문제 푸는 법 외워두기 <br>
 */

public class g4_11054_가장긴바이토닉부분수열 {
    public static int[] numbers;
    public static int[] upCounts;
    public static int[] downCounts;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        upCounts = new int[N];
        downCounts = new int[N];

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
        for (int middle = N - 1; middle >= 0; middle--) {
            // downCounts
            for (int arround = N - 1; arround > middle; arround--) {
                if (numbers[arround] < numbers[middle])
                    downCounts[middle] = Math.max(downCounts[middle], downCounts[arround] + 1);
            }
        }

//        System.out.println(Arrays.toString(upCounts));
//        System.out.println(Arrays.toString(downCounts));

        int result = 0;
        for (int n = 0; n < N; n++) {
            result = Math.max(result, upCounts[n] + downCounts[n]);
        }

        System.out.println(result + 1);

    }
}