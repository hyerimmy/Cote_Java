package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.19.
 * @notes - 에센셜4 <br>
 * - 1->2 가는 방법이 2가지라는 점 간과!!!!! (+1, *2)
 */

public class g4_12851_숨바꼭질2 {
    public static int N;
    public static int K;
    public static int MAX_POSITION = 100_000;
    public static Queue<Integer> Q = new LinkedList<>();
    public static int[] times = new int[MAX_POSITION + 1];
    public static int[] count = new int[MAX_POSITION + 1];
    public static int answerCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수빈 위치
        K = Integer.parseInt(st.nextToken()); // 동생 위치

        getMinTime();
        System.out.println(times[K]);
        System.out.println(count[K]);
    }

    public static void getMinTime() {
        Q.add(N);
        count[N] = 1;

        while (!Q.isEmpty()) {
            int P = Q.poll();

            updateTimes(P - 1, P);
            updateTimes(P + 1, P);
            updateTimes(P * 2, P);

//            System.out.println("poll number : " + P);
//            System.out.println(Arrays.toString(Arrays.copyOfRange(times, 0, 10)));
//            System.out.println(Arrays.toString(Arrays.copyOfRange(count, 0, 10)));
//            System.out.println();
        }
    }

    public static void updateTimes(int position, int prevPosition) {
        int time = times[prevPosition] + 1;

        if (position < 0 || position > MAX_POSITION)
            return;

        if (times[position] == 0 && position != N) {
            times[position] = time;
            Q.add(position);
        }

        if (times[position] == time)
            count[position] += count[prevPosition];

        if (position == K && times[K] == time)
            answerCount++;
    }
}