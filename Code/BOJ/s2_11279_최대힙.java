package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27.
 * @notes
 * - Priority Queue 활용 문제. 간단.
 */

public class s2_11279_최대힙 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> PQ = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            int inputN = Integer.parseInt(br.readLine());
            if (inputN == 0) {
                if (!PQ.isEmpty())
                    sb.append(PQ.poll()).append("\n");
                else
                    sb.append(0).append("\n");
            } else {
                PQ.add(inputN);
            }

        }

        System.out.println(sb);
    }
}
