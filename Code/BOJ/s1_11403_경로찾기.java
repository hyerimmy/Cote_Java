package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27.
 * @notes - 에센셜 3++<br>
 */

public class s1_11403_경로찾기 {

    public static boolean[][] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        line = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if(Integer.parseInt(st.nextToken()) == 1)
                    line[i][j] = true;
            }
        }

        for (int v = 0; v < N; v++) {
            for (int start = 0; start < N; start++) {
                for (int end = 0; end < N; end++) {
                    if(line[start][end])
                        continue;
                    if(line[start][v] && line[v][end])
                        line[start][end] = true;
                }
            }
        }

        // 정답 결과  출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(line[i][j]?1:0).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
