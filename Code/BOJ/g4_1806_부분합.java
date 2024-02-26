package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.26.
 * @notes - Priority Queue 활용 문제. 간단.
 */

public class g4_1806_부분합 {
    public static int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int answer = MAX_VALUE;
        Queue<Integer> Q = new LinkedList<>();
        int sum = 0;
        for (int number : numbers) {
            sum += number;
            Q.add(number);

            // 조건에 만족한다면
            if (sum >= S) {
                answer = Math.min(answer, Q.size());

                // 뺄 수 있는 만큼 빼보기
                while (!Q.isEmpty() && sum - Q.peek() >= S) {
                    sum -= Q.poll();
                    answer = Math.min(answer, Q.size());
                }
            }
        }

        if (answer == MAX_VALUE)
            answer = 0;
        System.out.println(answer);
    }
}
