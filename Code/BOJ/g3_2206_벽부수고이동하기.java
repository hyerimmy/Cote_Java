package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.12.
 * @notes - BFS, 어렵게 생각하지말고 Queue에 넣는 값이 하나(boolean canBreak) 더 있다 생각하기 <br>
 * - BFS + 메모리 초과 오류 -> 코드 최적화 덜된 것, visited 처리 위치를 제대로 생각할 것!
 */

public class g3_2206_벽부수고이동하기 {
    public static int N; // 세로
    public static int M; // 가로
    public static int[][] map; // 맵
    public static boolean[][] visitedCanBreakTrue; // 방문배열
    public static boolean[][] visitedCanBreakFalse; // 방문배열
    public static int result = -1; // 정답값

    public static int[] dx = new int[]{-1, 0, 1, 0};
    public static int[] dy = new int[]{0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visitedCanBreakTrue = new boolean[N][M];
        visitedCanBreakFalse = new boolean[N][M];

        // 맵 정보 입력받기
        for (int n = 0; n < N; n++) {
            String rowData = br.readLine();
            for (int m = 0; m < M; m++) {
                map[n][m] = rowData.charAt(m) - '0';
            }
        }

        // BFS 탐색
        BFS();

        // 결과 출력
        System.out.println(result);
    }

    private static void BFS() {
        Queue<Move> Q = new LinkedList<>();
        Q.add(new Move(0, 0, true, 1));

        while (!Q.isEmpty()) {
            Move move = Q.poll();

            // 목표지점에 도착했을 경우
            if (move.x == M - 1 && move.y == N - 1) {
                result = move.count;
                break;
            }

            // 목표지점이 아닐 경우
            for (int t = 0; t < 4; t++) {
                int newX = move.x + dx[t];
                int newY = move.y + dy[t];
                if (newX >= 0 && newX < M && newY >= 0 && newY < N) {
                    if (map[newY][newX] == 0) { // 벽이 아닐 경우
                        if(move.canBreak && !visitedCanBreakTrue[newY][newX]){
                            // 벽 뚫을 수 있는 상태이며 해당 상태로 방문하지 않았을 경우
                            Q.add(new Move(newX, newY, true, move.count + 1));
                            visitedCanBreakTrue[newY][newX] = true;
                        } else if(!move.canBreak && !visitedCanBreakFalse[newY][newX]){
                            // 벽 뚫을 수 없는 상태이며 해당 상태로 방문하지 않았을 경우
                            Q.add(new Move(newX, newY, false, move.count + 1));
                            visitedCanBreakFalse[newY][newX] = true;
                        }
//                        System.out.printf("[%d] (%d, %d) - %s %n", move.count + 1, newX, newY, move.canBreak);
                    } else if (map[newY][newX] == 1 && move.canBreak && !visitedCanBreakFalse[newY][newX]) { // 벽이고 부술 수 있을 경우
                        Q.add(new Move(newX, newY, false, move.count + 1));
                        visitedCanBreakFalse[newY][newX] = true;
//                        System.out.printf("[%d] (%d, %d) - %s %n", move.count + 1, newX, newY, false);
                    }
                }
            }
        }
    }

    private static class Move {
        public int x;
        public int y;
        public boolean canBreak;
        public int count;

        public Move(int x, int y, boolean canBreak, int count) {
            this.x = x;
            this.y = y;
            this.canBreak = canBreak;
            this.count = count;
        }
    }
}