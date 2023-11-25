package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 * - 이차원 배열 정렬 람다로 하기!!
 */

public class s1_1931_회의실배정 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 수

        int[][] times = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            times[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        Arrays.sort(times, (o1, o2) -> {
            if (o1[1] != o2[1])
                return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int endTime = 0;
        int count = 0;
        for (int[] time : times) {
            if (endTime <= time[0]) {
                count++;
                endTime = time[1];
            }
        }
        System.out.println(count);
    }
}

