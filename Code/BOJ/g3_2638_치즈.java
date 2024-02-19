package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.19
 * @notes - 4++<br>
 */

public class g3_2638_치즈 {
    public static int N, M;
    public static int[][] map;
    public static int cheeseCount = 0;

    public static int[] dN = new int[]{0, 0, 1, -1};
    public static int[] dM = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 모눈종이 정보 입력받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
                if (map[n][m] == 1) cheeseCount++;
            }
        }

        // 바깥 공기 마킹 (-1)
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                if ((n == 0 || n == N - 1 || m == 0 || m == M - 1) && map[n][m] == 0) {
                    markOutAir(n, m);
                }
            }
        }

        // 치즈 녹이기 반복
        int time = 0;
        while (cheeseCount > 0) {
            Queue<int[]> Q = new LinkedList<>();

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (canDisappear(n, m)) {
                        Q.add(new int[]{n, m});
                    }
                }
            }

            while (!Q.isEmpty()) {
                int[] p = Q.poll();
                markOutAir(p[0], p[1]);
                cheeseCount--;
            }
            time++;
        }

        // 결과 출력
        System.out.println(time);

    }

    // 녹을 치즈인지 확인
    private static boolean canDisappear(int n, int m) {
        // 치즈가 아니라면 false 반환
        if (map[n][m] != 1)
            return false;

        // 주변 외부공기 카운팅
        int outAirCount = 0;
        for (int k = 0; k < 4; k++) {
            int newN = n + dN[k];
            int newM = m + dM[k];
            if (newN >= 0 && newN < N && newM >= 0 && newM < M && map[newN][newM] == -1) {
                outAirCount++;
            }
        }

        // 외부 공기 2칸 이상일 경우 true반환
        return outAirCount >= 2;
    }

    // 바깥 공기 마킹 함수, DFS
    private static void markOutAir(int n, int m) {
        map[n][m] = -1;

        for (int k = 0; k < 4; k++) {
            int newN = n + dN[k];
            int newM = m + dM[k];
            if (newN >= 0 && newN < N && newM >= 0 && newM < M && map[newN][newM] == 0) {
                markOutAir(newN, newM);
            }
        }
    }
}

/*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0
 */