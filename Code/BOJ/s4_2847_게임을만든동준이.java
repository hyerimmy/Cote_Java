package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @link https://www.acmicpc.net/problem/2847
 * @date 2024.05.08
 * @notes - <br>
 */

public class s4_2847_게임을만든동준이 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> scores = new Stack<>();
        for (int i = 0; i < N; i++) {
            scores.push(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        int prev = scores.pop();
        while (!scores.isEmpty()) {
            int current = scores.pop();
            if (current >= prev) {
                count += (current - (prev - 1));
                current = prev - 1;
            }
            prev = current;
        }

        System.out.println(count);
    }
}

