package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2+ <br>
 */

public class s5_11866_요세푸스문제0 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            Q.add(i);

        int[] answerA = new int[N];
        int idx = 0;
        while (!Q.isEmpty()) {
            // k-1번째까지 지나서
            for (int k = 0; k < K - 1; k++)
                Q.add(Q.poll());
            // k 번째 값 빼기
            answerA[idx++] = Q.poll();
        }

        System.out.print("<");
        for (int i = 0; i < answerA.length; i++) {
            System.out.print(answerA[i]);
            if (i != answerA.length - 1)
                System.out.print(", ");
        }
        System.out.print(">");


    }
}