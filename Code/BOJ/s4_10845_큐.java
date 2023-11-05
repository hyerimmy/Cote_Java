package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2<br>
 */

public class s4_10845_큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int backN = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    int inputN = Integer.parseInt(st.nextToken());
                    queue.add(inputN);
                    backN = inputN;
                    break;
                case "pop":
                    System.out.println(queue.isEmpty()?-1:queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty()?-1:queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty()?-1:backN);
                    break;
            }
        }
    }
}