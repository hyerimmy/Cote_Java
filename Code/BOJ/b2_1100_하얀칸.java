package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem/1100
 * @date 2024.05.06
 * @notes - <br>
 */

public class b2_1100_하얀칸 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        for (int row = 0; row < 8; row++) {
            String data = br.readLine();
            for (int col = row % 2; col < 8; col += 2) {
                if (data.charAt(col) == 'F') {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}

