package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.05
 * @notes -
 */

public class g4_14502_연구소 {
    public static int N, M; // 세로, 가로 크기
    public static int[][] lab; // 연구실 칸 정보
    public static boolean[][] counted; // 연구실 방문 배열 (안전영역 세기)

    public static int virusCount = 0; // 최대 영역 크기
    public static int wallCount = 0; // 벽 개수
    public static int maxSafeCount = 0; // 최대 영역 크기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        // 연구실 정보 입력받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                lab[n][m] = Integer.parseInt(st.nextToken());
                if (lab[n][m] == 1)
                    wallCount++;
            }
        }

        // 벽 세우기
        setWall(0);

        // 결과출력
        System.out.println(maxSafeCount);
    }

    // 백트래킹
    private static void setWall(int wallCount) {
        // 벽 3개 세웠다면 안전 영역 계산하고 종료
        if (wallCount == 3) {
            maxSafeCount = Math.max(maxSafeCount, getSafeArea());
            return;
        }

        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (lab[n][m] == 0) {
                    lab[n][m] = 1;
                    setWall(wallCount + 1);
                    lab[n][m] = 0;
                }
            }
        }
    }

    private static int getSafeArea() {
        counted = new boolean[N][M];
        virusCount = 0;

        // 바이러스 개수 세기 (DFS)
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if (lab[n][m] == 2 && !counted[n][m]) {
                    countVirus(n, m);
                }
            }
        }

        return N * M - wallCount - 3 - virusCount;
    }

    // DFS 탐색
    private static void countVirus(int n, int m) {
        counted[n][m] = true;
        virusCount++;

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        for (int t = 0; t < 4; t++) {
            if (n + dx[t] >= 0 && n + dx[t] < N && m + dy[t] >= 0 && m + dy[t] < M
                    && lab[n + dx[t]][m + dy[t]] == 0
                    && !counted[n + dx[t]][m + dy[t]]
            ) {
                countVirus(n + dx[t], m + dy[t]);
            }
        }
    }
}
