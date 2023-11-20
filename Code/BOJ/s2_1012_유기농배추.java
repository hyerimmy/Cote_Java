package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.21.
 * @notes - 에센셜3 <br>
 */

public class s2_1012_유기농배추 {
    public static boolean[][] B;
    public static int M; // 가로
    public static int N; // 세로
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 배추밭 정보 입력받기
            B = new boolean[N+1][M+1];
            for (int k = 0; k < K; k++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                B[num2][num1] = true;
            }

            // 배추밭 탐색하며 벌레 DFS
            int answer = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (B[i][j]) {
                        DFS(i, j);
                        answer++;
                    }

                }
            }

            // 정답값 저장
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static void DFS(int i, int j) {
        B[i][j] = false;
        for (int d = 0; d < 4; d++) {
            int newX = i + dx[d];
            int newY = j + dy[d];
            if (newX >= 0 && newX < N && newY >= 0 && newY<M && B[newX][newY]){
                DFS(newX, newY);
            }
        }
    }
}