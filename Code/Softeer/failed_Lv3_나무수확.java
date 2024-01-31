package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
시간초과남 - 왜????????
 */

public class failed_Lv3_나무수확 {
    public static int N;
    public static int[][] map;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 씨앗 정보 입력받기
        map = new int[N][N];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // BFS 탐색 시작
        BFS();

        // 결과 출력
        System.out.println(answer);
    }

    private static void BFS() {
        Queue<WaterLine> Q = new LinkedList<>();

        // 초기값 넣기
        Q.add(new WaterLine(0, 0, map[0][0], map[0][0]));

        while (!Q.isEmpty()) {
            WaterLine WL = Q.poll();

            // 만약 끝점에 도착했다면 answer 업데이트
            if (WL.row == N - 1 && WL.col == N - 1) {
                answer = Math.max(answer, WL.sum + WL.max);
                continue;
            }

            // #1. 만약 좌표를 벗어나지 않는다면 오른쪽으로 이동
            if (WL.col + 1 < N) {
                Q.add(new WaterLine(
                        WL.row,
                        WL.col + 1,
                        Math.max(WL.max, map[WL.row][WL.col + 1]),
                        WL.sum + map[WL.row][WL.col + 1]
                ));
            }

            // #2. 만약 좌표를 벗어나지 않는다면 아래쪽으로 이동
            if (WL.row + 1 < N) {
                Q.add(new WaterLine(
                        WL.row + 1,
                        WL.col,
                        Math.max(WL.max, map[WL.row + 1][WL.col]),
                        WL.sum + map[WL.row + 1][WL.col]
                ));
            }
        }

    }

    private static class WaterLine {
        public int row;
        public int col;
        public int max = 0;
        public int sum = 0;

        public WaterLine(int row, int col, int max, int sum) {
            this.row = row;
            this.col = col;
            this.max = max;
            this.sum = sum;
        }

        public void updateValue(int value) {
            this.max = Math.max(this.max, value);
            this.sum += value;
        }
    }
}
