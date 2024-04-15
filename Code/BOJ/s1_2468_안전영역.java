package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/2468
 * @date 2024.04.15
 * @notes - 1트 성공 <br>
 */

public class s1_2468_안전영역 {
    public static int[] dX = new int[]{1, 0, -1, 0};
    public static int[] dY = new int[]{0, 1, 0, -1};

    public static int N;
    public static int[][] map;
    public static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 지형 입력받기
        map = new int[N][N];
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < N; m++) {
                map[n][m] = Integer.parseInt(st.nextToken());
//                Random rd = new Random();
//                map[n][m] = rd.nextInt(100) + 1;
            }
        }

        int maxCount = 1;

        // 높이 1~100 에 따른 안전영역 계산하기
        for (int safeH = 1; safeH <= 100; safeH++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int n = 0; n < N; n++) {
                for (int m = 0; m < N; m++) {
                    if (!visited[n][m] && map[n][m] > safeH) {
                        visitArea(n, m, safeH);
                        count++;
                    }
                }
            }

            maxCount = Math.max(maxCount, count);
            if (count == 0) {
                break;
            }
        }

        // 결과 출력
        System.out.println(maxCount);
    }

//    private static void visitArea(int n, int m, int safeH) {
//        visited[n][m] = true;
//
//        for (int d = 0; d < 4; d++) {
//            int newN = n + dX[d];
//            int newM = m + dY[d];
//
//            // 범위를 벗어난다면 건너뛰기
//            if (newN < 0 || newN >= N || newM < 0 || newM >= N) {
//                continue;
//            }
//
//            // 이미 방문한 노드라면 건너뛰기
//            if (visited[newN][newM]) {
//                continue;
//            }
//
//            // 안전한 영역이 아니라면 건너뛰기
//            if (map[newN][newM] <= safeH) {
//                continue;
//            }
//
//            visitArea(newN, newM, safeH);
//        }
//    }

    private static void visitArea(int n, int m, int safeH) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{n, m});
        visited[n][m] = true;

        while (!Q.isEmpty()) {
            int[] data = Q.poll();

            for (int d = 0; d < 4; d++) {
                int newN = data[0] + dX[d];
                int newM = data[1] + dY[d];

                // 범위를 벗어난다면 건너뛰기
                if (newN < 0 || newN >= N || newM < 0 || newM >= N) {
                    continue;
                }

                // 이미 방문한 노드라면 건너뛰기
                if (visited[newN][newM]) {
                    continue;
                }

                // 안전한 영역이 아니라면 건너뛰기
                if (map[newN][newM] <= safeH) {
                    continue;
                }

                Q.add(new int[]{newN, newM});
                visited[newN][newM] = true;
            }
        }


    }
}

