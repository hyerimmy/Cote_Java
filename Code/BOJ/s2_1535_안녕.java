package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/1535
 * @date 2024.05.24
 * @notes - <br>
 */

public class s2_1535_안녕 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] healths = new int[N + 1];
        int[] joys = new int[N + 1];

        StringTokenizer healthsInput = new StringTokenizer(br.readLine());
        StringTokenizer joysInput = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            healths[i] = Integer.parseInt(healthsInput.nextToken());
            joys[i] = Integer.parseInt(joysInput.nextToken());
        }

        int maxJoy = 0;
        int[][] backpack = new int[N + 1][100];
        for (int person = 1; person <= N; person++) {
            for (int health = 0; health <= 99; health++) {
                backpack[person][health] = backpack[person - 1][health];

                if (healths[person] <= health) {
                    backpack[person][health] = Math.max(backpack[person][health], backpack[person - 1][health - healths[person]] + joys[person]);
                }

                // 최대값 갱신
                maxJoy = Math.max(maxJoy, backpack[person][health]);
            }
        }

        System.out.println(maxJoy);
    }
}

