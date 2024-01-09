package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2+ <br>
 * - ㅋㅋㅋ.. 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자... 문제 제대로 읽자.. <br>
 */

public class g5_14503_로봇청소기 {
    public static int N, M;
    public static int[][] room;
    public static boolean[][] clean;
    public static int[] dR = new int[]{-1, 0, 1, 0};
    public static int[] dC = new int[]{0, 1, 0, -1};
    public static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        clean = new boolean[N][M];

        // 로봇청소기 정보 입력받기
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        // 방 정보 입력받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                room[n][m] = Integer.parseInt(st.nextToken());
            }
        }

        // 청소 시작
        cleanRoom(r, c, d);

        // 결과 출력
        System.out.println(result);
    }

    private static void cleanRoom(int r, int c, int d) {
        // 1. 현재 칸 청소되지 않았다면 청소
        if (!clean[r][c]) {
            clean[r][c] = true;
            result++;
        }


        if (isAroundClean(r, c)) { // 2. 주변 4칸 중 청소되지 않은 빈 칸이 없다면
            if (canGoBack(r, c, d)) {
                // 2-1. 후진 가능하다면 방향 유지, 한칸 후진
                cleanRoom(r + dR[d] * -1, c + dC[d] * -1, d);
            } else {
                // 2-2. 후진할 수 없다면 작동 종료
                return;
            }
        } else { // 3. 주변 4칸 중 청소되지 않은 빈 칸이 있다면
            // 3-1. 반시계 방향 90도 회전
            if (--d == -1)
                d = 3;
            // 3-2. 바라보는 방향 기준 앞이 청소되지 않은 빈칸인 경우 한 칸 전진
            if (r + dR[d] >= 0 && r + dR[d] < N && c + dC[d] >= 0 && c + dC[d] < M
                    && room[r + dR[d]][c + dC[d]] != 1
                    && !clean[r + dR[d]][c + dC[d]]) {
                r += dR[d];
                c += dC[d];
            }
            // 3. 1로 돌아가기
            cleanRoom(r, c, d);
        }
    }

    private static boolean isAroundClean(int r, int c) {
        for (int t = 0; t < 4; t++) {
            if (r + dR[t] >= 0 && r + dR[t] < N && c + dC[t] >= 0 && c + dC[t] < M
                    && room[r + dR[t]][c + dC[t]] != 1
                    && !clean[r + dR[t]][c + dC[t]])
                return false;
        }
        return true;
    }

    private static boolean canGoBack(int r, int c, int d) {
        int newR = r + dR[d] * -1;
        int newC = c + dC[d] * -1;

        if (newR >= 0 && newR < N && newC >= 0 && newC < M && room[newR][newC] != 1)
            return true;
        return false;
    }
}
