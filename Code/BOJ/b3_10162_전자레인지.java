package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/10162
 * @date 2024.05.08
 * @notes - <br>
 */

public class b3_10162_전자레인지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        // A : 300, B : 60, C : 10
        int[] times = new int[]{300, 60, 10};
        int[] count = new int[3];

        for (int i = 0; i < 3; i++) {
            int time = times[i];
            count[i] += T / time;
            T %= time;
        }

        if (T != 0) {
            System.out.println(-1);
        } else {
            System.out.println(count[0] + " " + count[1] + " " + count[2]);
        }
    }
}

