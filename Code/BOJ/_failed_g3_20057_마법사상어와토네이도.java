package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.07
 * @notes - <br>
 */

public class _failed_g3_20057_마법사상어와토네이도 {
    public static int N;
    public static int[][] dust;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dust = new int[N][N];

        // 초기 모래 입력받기
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                dust[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        // 테스트용
        int[][] test = new int[N][N];

        // 토네이도
        int row = N / 2;
        int col = N / 2;
        int directionIdx = -1;
        int moveDistance = 0;
        int idx = 1;
        while (row != 1 && col != 1) {
            moveDistance++;
            directionIdx++;
            for (int k = 0; k < moveDistance; k++) {
                test[row][col] = idx++;
            }
//            moveWind(row, col);

        }
    }

    private static void moveWind(int row, int col) {

    }

}

