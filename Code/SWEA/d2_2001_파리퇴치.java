package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PzOCKAigDFAUq&categoryId=AV5PzOCKAigDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * @date 2023.11.18
 * @notes
 */

public class d2_2001_파리퇴치 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            map[1][1] = Integer.parseInt(st.nextToken());
            for (int j = 2; j <= N; j++) {
                map[1][j] = map[1][j - 1] + Integer.parseInt(st.nextToken());
            }

            for (int i = 2; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                map[i][1] = map[i - 1][1] + Integer.parseInt(st.nextToken());
                for (int j = 2; j <= N; j++) {
                    map[i][j] = map[i][j - 1] + map[i - 1][j] - map[i - 1][j - 1] +Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    int sum = map[i][j] - map[i - M][j] - map[i][j - M] + map[i - M][j - M];
                    answer = Math.max(sum, answer);
                }
            }

            System.out.print("#" + t + " " + answer);
        }
    }
}