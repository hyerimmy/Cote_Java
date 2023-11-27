package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27.
 * @notes - 에센셜 3++<br>
 */

public class failed_s1_11403_경로찾기 {
    public static int[][] line;
    public static boolean[] visited;
    public static int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        line = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                line[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N];
        answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            // 스스로에게 가는 경로 1로 설정
            answer[i][i] = 1;

            for (int j = 0; j < N; j++) {
                if (!visited[i]) {
                    DFS(i, new ArrayList<>());
                }
            }
        }

        // 정답 결과  출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void DFS(int i, List<Integer> prevL) {
        for (int prev : prevL) {
            answer[prev][i] = 1;
        }
        prevL.add(i);

        // 본인에서 시작되는 길이 있다면 DFS 호출
        for (int t = 0; t < line[i].length; t++) {
            if (line[i][t] == 1) {
                DFS(t, prevL);
            }
        }

        // i로부터 시작하는 간선은 모두 방문함
        visited[i] = true;

    }
}