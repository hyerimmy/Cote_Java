package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem/1075
 * @date 2024.05.05
 * @notes - <br>
 */

public class b2_1075_나누기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        int base = (N / 100) * 100;
        for (int tail = 0; tail <= 99; tail++) {
            int number = base + tail;
            if (number % F == 0) {
                if (tail < 10) {
                    System.out.println("0" + tail);
                } else {
                    System.out.println(tail);
                }
                return;
            }
        }
    }
}

