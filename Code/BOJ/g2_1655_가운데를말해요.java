package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.08
 * @notes - 블로그 참고함. 천재적인 풀이.. 기억하자!
 */

public class g2_1655_가운데를말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> leftPQ = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int n = 0; n < N; n++) {
            int value = Integer.parseInt(br.readLine());

            // 오른쪽에 먼저 넣기
            rightPQ.add(value);

            // 1 3 / 2 4 5
            // 경계선 쪽 값이 정렬되어 있지 않다면 swap!
            if (!leftPQ.isEmpty() && leftPQ.peek() > rightPQ.peek()) {
                int temp = leftPQ.poll();
                leftPQ.add(rightPQ.poll());
                rightPQ.add(temp);
            }

            // 왼쪽이 오른쪽보다 적다면 왼쪽으로 값 한 개 넘기기
            if (leftPQ.size() < rightPQ.size()) {
                leftPQ.add(rightPQ.poll());
            }

            // 결과 저장
            sb.append(leftPQ.peek()).append("\n");
        }

        System.out.println(sb);
    }
}
