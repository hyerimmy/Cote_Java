package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.08.
 * @notes -
 */

public class s1_14889_스타트와링크 {
    public static int[][] powers;
    public static int N;
    public static boolean[] isTeam1;
    public static int team1Score = 0;
    public static int team2Score = 0;
    public static int minResult = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        isTeam1 = new boolean[N];
        powers = new int[N][N];

        // 능력치 입력받기
        for (int a = 0; a < N; a++) {
            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < N; b++) {
                powers[a][b] = Integer.parseInt(st.nextToken());
                team2Score += powers[a][b];
            }
        }

        // 백트래킹
        BT(0, 0);

        System.out.println(minResult);
    }

    private static void BT(int start, int count) {
        if (count == N / 2) {
//            System.out.println(Arrays.toString(isTeam1) + " -> " + Math.abs(team1Score - team2Score));
            if (minResult == -1)
                minResult = Math.abs(team1Score - team2Score);
            minResult = Math.min(minResult, Math.abs(team1Score - team2Score));
            return;
        }

        for (int n = start; n < N; n++) {
            int s1 = 0;
            int s2 = 0;
            for (int nn = 0; nn < N; nn++) {
                if (isTeam1[nn]) {
                    s1 += (powers[n][nn] + powers[nn][n]);
                } else {
                    s2 += (powers[n][nn] + powers[nn][n]);
                }

            }

            isTeam1[count] = true;
            team1Score += s1;
            team2Score -= s2;

            BT(n + 1, count + 1);

            isTeam1[count] = false;
            team1Score -= s1;
            team2Score += s2;
        }
    }
}