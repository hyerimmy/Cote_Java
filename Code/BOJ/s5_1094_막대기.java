package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @title 1094 막대기
 * @link https://www.acmicpc.net/problem/1094
 * @date 2024.03.22
 * @notes - 연습<br>
 */

public class s5_1094_막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());

        int totalLength = 64;

        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        minQ.add(64);

        while (!minQ.isEmpty() && totalLength > X) {
            int minLength = minQ.poll();
            minQ.add(minLength / 2);
            minQ.add(minLength / 2);

            if (totalLength - minQ.peek() >= X) {
                totalLength -= minQ.poll();
            }

//            System.out.println(minQ);
        }

        System.out.println(minQ.size());
    }
}