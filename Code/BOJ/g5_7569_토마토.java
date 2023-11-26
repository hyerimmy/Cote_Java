package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.26
 * @notes - 에센셜3++<br>
 */

public class g5_7569_토마토 {
    static int N;
    static int M;
    static int H;
    static int[][][] B;
    static int targetCnt = 0;
    static int[] DN = {1, 0, -1, 0, 0, 0};
    static int[] DM = {0, -1, 0, 1, 0, 0};
    static int[] DH = {0, 0, 0, 0, 1, -1};
    static int days = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        B = new int[H][N][M];

        Queue<int[]> Q = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    B[h][n][m] = Integer.parseInt(st.nextToken());
                    if (B[h][n][m] == 0) targetCnt++;
                    if (B[h][n][m] == 1) Q.add(new int[]{h, n, m});
                }
            }
        }

        if (targetCnt == 0) days = 0;
        else BFS(Q);

        System.out.println(days);
    }

    public static void BFS(Queue<int[]> Q) {
        while (!Q.isEmpty()) {
            int[] T = Q.poll();
            for (int d = 0; d < 6; d++) {
                int newH = T[0] + DH[d];
                int newN = T[1] + DN[d];
                int newM = T[2] + DM[d];

                if (newH >= 0 && newH < H && newN >= 0 && newN < N && newM >= 0 && newM < M && B[newH][newN][newM] == 0) {
                    Q.add(new int[]{newH, newN, newM});
                    B[newH][newN][newM] = B[T[0]][T[1]][T[2]] + 1;
                    targetCnt--;
                    if (targetCnt == 0) days = B[newH][newN][newM] - 1;
                }
            }
        }
    }
}

