package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.29
 * @notes - 백준 <br>
 */

public class s5_9655_돌게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        // 5
        // 1 1 1 1 1
        // 1 1 3

        // 6
        // 3 3
        // 1 1 1 1 1 1
        // 1 3 1 1

        // 7
        // 1 3 3
        // 1 1 1 1 3

        // 3 = 1 + 1 + 1 (홀=홀)
        // 홀수 = SK 상근, 짝수 = CY 창영

        if (N % 2 == 1)
            System.out.println("SK");
        else
            System.out.println("CY");

        br.close();
    }
}