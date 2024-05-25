package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/4101
 * @date 2024.05.25
 * @notes - <br>
 */

public class b5_4101_크냐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (a > b) {
                sb.append("Yes").append("\n");
            } else {
                sb.append("No").append("\n");
            }
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (a == 0 && b == 0) {
                break;
            }
        }

        System.out.println(sb);
    }
}

