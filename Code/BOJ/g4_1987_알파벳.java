package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.16.
 * @notes - 에센셜4 <br>
 * - 백트래킹 문제, 뭔가 이제 원리를 이해해서 잘 풀 수 있을거같은 그런 느낌 <br>
 */

public class g4_1987_알파벳 {
    public static int R;
    public static int C;
    public static char[][] board;
    public static HashMap<Character, Boolean> alphabetVisit = new HashMap<>();
    public static int maxResult = 0;

    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        // 보드 입력받기
        for (int r = 0; r < R; r++) {
            String rowData = br.readLine();
            for (int c = 0; c < C; c++) {
                board[r][c] = rowData.charAt(c);
                alphabetVisit.put(board[r][c], false);
            }
        }

        // DFS + 백트래킹
        alphabetVisit.put(board[0][0], true);
        searchRoute(0, 0,1);

        // 결과 출력
        System.out.println(maxResult);
    }

    public static void searchRoute(int r, int c, int count) {
        maxResult = Math.max(maxResult, count);

        for (int t = 0; t < 4; t++) {
            int newR = r + dx[t];
            int newC = c + dy[t];

            if (newR < 0 || newR >= R || newC < 0 || newC >= C)
                continue;

            if (alphabetVisit.get(board[newR][newC]))
                continue;

            alphabetVisit.put(board[newR][newC], true);
            searchRoute(newR, newC, count + 1);
            alphabetVisit.put(board[newR][newC], false);
        }
    }
}