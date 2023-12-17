package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.16.
 * @notes - 에센셜4 <br>
 */

public class g4_2448_별찍기11 {
    public static boolean[][] starArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int columnSize = 5 * (N / 3) + (N / 3 - 1);
        starArray = new boolean[N][columnSize];

        writeStar(N / 3, new int[]{0, N - 1});

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < N; row++) {
            for (int column = 0; column < columnSize; column++) {
                if (starArray[row][column])
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void writeStar(int size, int[] top) {
        if (size == 1) {
            for (int depth = 0; depth < 3; depth++) {
                int blank = 3 - depth - 1;
                for (int count = 0; count <= 2 - blank; count++) {
                    starArray[top[0] + depth][top[1] - count] = true;
                    starArray[top[0] + depth][top[1] + count] = true;
                }
            }
            starArray[top[0] + 1][top[1]] = false;
            return;
        }

        writeStar(size / 2, top);

        int unit = size / 2 * 3;
        writeStar(size / 2, new int[]{top[0] + unit, top[1] + unit});
        writeStar(size / 2, new int[]{top[0] + unit, top[1] - unit});
    }
}