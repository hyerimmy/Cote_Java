package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.25
 * @notes - 기하학 <br>
 */

public class _failed_s3_1002_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] p1 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int r1 = Integer.parseInt(st.nextToken());
            int[] p2 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int r2 = Integer.parseInt(st.nextToken());

            double distancePow = Math.pow((p2[0] - p1[0]), 2) + Math.pow((p2[1] - p1[1]), 2);

            if (distancePow < Math.pow(Math.max(r1, r2) - Math.min(r1, r2), 2))
                sb.append(0).append("\n");
            else if (distancePow > Math.pow(r1 + r2, 2))
                sb.append(0).append("\n");
            else if (distancePow < Math.pow(r1 + r2, 2))
                sb.append(2).append("\n");
            else if (distancePow == Math.pow(r1 + r2, 2))
                sb.append(1).append("\n");
        }

        System.out.println(sb);
    }
}

