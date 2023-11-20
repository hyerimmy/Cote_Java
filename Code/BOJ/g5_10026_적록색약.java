package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.21.
 * @notes - 에센셜3 <br>
 */

public class g5_10026_적록색약 {
    public static int N;
    public static char[][] M;
    public static boolean[][] visited1;
    public static boolean[][] visited2;
    public static int answer1 = 0; // R + G + B
    public static int answer2 = 0; // (R+G) + B
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 크기
        M = new char[N][N];
        visited1 = new boolean[N][N];
        visited2 = new boolean[N][N];

        // 그리드 값 채우기
        for (int i = 0; i < N; i++) {
            String rowData = br.readLine();
            for (int j = 0; j < N; j++) {
                M[i][j] = rowData.charAt(j);
            }
        }

        // 그리드 탐색하며 카운팅
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] == 'B') {
                    if(!visited1[i][j]){
                        visitB(i, j);
                        answer1++;
                        answer2++;
                    }
                }
                else {
                    if(!visited1[i][j]){
                        visitTarget(i,j,M[i][j]);
                        answer1++;
                    }
                    if(!visited2[i][j]){
                        visitNotB(i,j);
                        answer2++;
                    }
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    // ans1, ans2 모두 해당
    public static void visitB(int i, int j) {
        visited1[i][j] = true; // 조회 처리
        visited2[i][j] = true; // 조회 처리

        for (int t = 0; t < 4; t++) {
            int newX = i + dx[t];
            int newY = j + dy[t];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N && M[newX][newY] == 'B' && !visited1[newX][newY]) {
                visitB(newX, newY);
            }
        }
    }

    // ans1 해당
    public static void visitTarget(int i, int j, char target) {
        visited1[i][j] = true; // 조회 처리

        for (int t = 0; t < 4; t++) {
            int newX = i + dx[t];
            int newY = j + dy[t];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N && M[newX][newY] == target && !visited1[newX][newY]) {
                visitTarget(newX, newY, target);
            }
        }
    }

    // ans2 해당
    public static void visitNotB(int i, int j) {
        visited2[i][j] = true; // 조회 처리

        for (int t = 0; t < 4; t++) {
            int newX = i + dx[t];
            int newY = j + dy[t];

            if (newX >= 0 && newX < N && newY >= 0 && newY < N && M[newX][newY] != 'B' && !visited2[newX][newY]) {
                visitNotB(newX, newY);
            }
        }
    }
}