package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem/17070
 * @date 2024.02.16.
 * @notes - 노트 꺼내기 싫어서 주석으로 알고리즘을 설계해봤는데 굉장히 비효율적~ <br>
 * - 블로그 참고함. BFS(Queue활용) -> 그냥 for 반복문으로 탐색 해야 풀렸음. (왜일까?????앙??( <br>
 */

public class g5_17070_파이프옮기기1 {
    public static int N;
    public static boolean[][] isEmpty;
    public static int[][][] dp;

    public static int RIGHT = 0;
    public static int DOWN = 1;
    public static int DIAGONAL = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isEmpty = new boolean[N + 1][N + 1];
        dp = new int[N + 1][N + 1][3];

        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                if (Integer.parseInt(st.nextToken()) == 0) {
                    isEmpty[row][col] = true;
                }
            }
        }

        // dp 초기화
        dp[1][2][RIGHT] = 1;

        // dp 탐색
        for (int row = 1; row <= N; row++) {
            for (int col = 2; col <= N; col++) {
                if (row == 1 && col == 2)
                    continue;
                setCountNumber(row, col);
            }
        }

        // 테스트 출력
//        for (int row = 1; row <= N; row++) {
//            for (int col = 1; col <= N; col++) {
//                System.out.print("(" + dp[row][col][RIGHT] + ", " + dp[row][col][DOWN] + ", " + dp[row][col][DIAGONAL] + ")");
//            }
//            System.out.println();
//        }

        // 결과 출력
        System.out.println(dp[N][N][RIGHT] + dp[N][N][DOWN] + dp[N][N][DIAGONAL]);
    }

    private static void setCountNumber(int row, int col) {
        // 벽이라면 종료
        if (!isEmpty[row][col])
            return;

        // 오른쪽으로 밀리는 경우 카운팅한다.
        if (isEmpty[row][col - 1]) {
            dp[row][col][RIGHT] = dp[row][col - 1][RIGHT] + dp[row][col - 1][DIAGONAL];
        }

        // 아래로 밀리는 경우 카운팅한다.
        if (isEmpty[row - 1][col]) {
            dp[row][col][DOWN] = dp[row - 1][col][DOWN] + dp[row - 1][col][DIAGONAL];
        }

        // 대각선으로 밀리는 경우 카운팅한다. (대각선은 벽이 아니어야 하는 공간이 3곳)
        if (isEmpty[row - 1][col - 1] && isEmpty[row - 1][col] && isEmpty[row][col - 1]) {
            dp[row][col][DIAGONAL] = dp[row - 1][col - 1][DIAGONAL] + dp[row - 1][col - 1][DOWN] + dp[row - 1][col - 1][RIGHT];
        }
    }
}

/*
16
0 0 0 0 0 0 0 0 0 1 0 0 0 0 0 1
0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 1 0 0 0 0 0
0 0 1 0 0 0 0 0 0 0 0 1 0 0 0 0
0 0 0 0 0 0 0 0 1 1 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0
0 0 0 0 0 0 0 0 0 0 0 0 1 1 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0

correct: 664
wrong: 609
 */