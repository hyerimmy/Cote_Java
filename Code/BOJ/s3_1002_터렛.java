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

public class s3_1002_터렛 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            int distancePow = (int) (Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

            if (r1 == r2 && x1 == x2 && y1 == y2) { // #1 두 원이 정확히 겹치는 경우
                sb.append(-1).append("\n");
            } else if (distancePow < Math.pow(r2 - r1, 2)) { // #2 원 안에 있으나 겹치지 않는 경우
                sb.append(0).append("\n");
            } else if (distancePow > Math.pow(r1 + r2, 2)) { // #3 두 원이 멀리 떨어져 겹치지 않는 경우
                sb.append(0).append("\n");
            } else if (distancePow == Math.pow(r2 - r1, 2)) { // #4 내접하는 경우
                sb.append(1).append("\n");
            } else if (distancePow == Math.pow(r1 + r2, 2)) { // #5 외접하는 경우
                sb.append(1).append("\n");
            } else {
                sb.append(2).append("\n");
            }
        }

        System.out.println(sb);
    }
}

