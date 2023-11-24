package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 */

public class s2_2630_색종이만들기 {
    public static int[][] paper;
    public static int bluePaperCount = 0;
    public static int whitePaperCount = 0;
    public static int[] dx = new int[]{0, 1, 0, 1};
    public static int[] dy = new int[]{0, 0, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 한 변의 길이

        paper = new int[N + 1][N + 1];

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken()) + paper[i - 1][j] + paper[i][j - 1] - paper[i - 1][j - 1];
            }
        }

        countPaper(1, 1, N);
        System.out.println(whitePaperCount);
        System.out.println(bluePaperCount);
    }

    public static void countPaper(int startI, int startJ, int length) {
        if (isComplete(startI, startJ, length))
            return;

        int newLength = length / 2;
        for (int t = 0; t < 4; t++)
            countPaper(startI + newLength * dx[t], startJ + newLength * dy[t], newLength);
    }

    public static boolean isComplete(int startI, int startJ, int length) {
        int endI = startI + length - 1;
        int endJ = startJ + length - 1;
        int blueCount = paper[endI][endJ] - paper[startI - 1][endJ] - paper[endI][startJ - 1] + paper[startI - 1][startJ - 1];

        if (blueCount == 0) {
            whitePaperCount++;
            return true;
        }
        if (blueCount == length * length) {
            bluePaperCount++;
            return true;
        }
        return false;
    }
}

