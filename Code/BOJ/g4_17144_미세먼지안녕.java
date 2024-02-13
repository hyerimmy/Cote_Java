package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.13
 * @notes - 빡구현 + 탐색 <br>
 */

public class g4_17144_미세먼지안녕 {
    public static int R, C;
    public static int[][] map;
    public static int[][] machine = new int[2][2]; // [0] : 위, [1] : 아래

    // 시계방향
    public static int[] dRow = new int[]{0, 1, 0, -1};
    public static int[] dCol = new int[]{1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        // 미세먼지 정보 입력받기
        boolean findMachine = false;
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
                if (map[r][c] == -1 && !findMachine) {
                    machine[0] = new int[]{r, c};
                    machine[1] = new int[]{r + 1, c};
                    findMachine = true;
                }
            }
        }

        for (int t = 0; t < T; t++) {
//            System.out.println("< t > : " + t);
            spreadDust(); // 미세먼지 확산
//            printMap();

            machineOn(machine[0], -1); // 공기청정기 작동 - 윗부분, 반시계방향
            machineOn(machine[1], 1); // 공기청정기 작동 - 아랫부분, 시계방향
//            printMap();
        }

        System.out.println(countDust());


    }

    private static void printMap() {
        for (int r = 0; r < R; r++) {
            System.out.println(Arrays.toString(map[r]));
        }
        System.out.println();
    }

    private static void spreadDust() {
        // 현재 미세먼지 큐에 저장
        Queue<Dust> Q = new LinkedList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0)
                    Q.add(new Dust(r, c, map[r][c]));
            }
        }

        // 미세먼지 확산
        while (!Q.isEmpty()) {
            Dust D = Q.poll();

            int spreadAmount = D.value / 5; // 확산 먼지 양
            int spreadCount = 0; // 확산 방향 수

            // 주변으로 먼지 확산
            for (int t = 0; t < 4; t++) {
                int newR = D.row + dRow[t];
                int newC = D.col + dCol[t];
                if (newR >= 0 && newR < R && newC >= 0 && newC < C && map[newR][newC] != -1) {
                    map[newR][newC] += spreadAmount;
                    spreadCount++;
                }
            }

            // 현재 칸 먼지 양 업데이트
            map[D.row][D.col] -= spreadAmount * spreadCount;
        }
    }

    private static void machineOn(int[] machine, int direction) {
        int d = 0;
        int[] current = new int[]{machine[0], machine[1]};
        int moveDust = 0;

        // 먼지 이동
        while (true) {
            // 칸 이동
            current[0] += dRow[d];
            current[1] += dCol[d];

            // 출발지로 돌아왔다면 종료
            if (current[0] == machine[0] && current[1] == machine[1])
                break;

            // 범위를 벗어난다면 이동 복구하고 방향 전환
            if (current[0] < 0 || current[0] >= R || current[1] < 0 || current[1] >= C) {
                current[0] -= dRow[d];
                current[1] -= dCol[d];
                d += direction; // direction 1 : 시계방향, -1 : 반시계방향
                if (d == -1) d = 3;
                if (d == 4) d = 0;
                continue;
            }

            // 먼지 이동
            int temp = map[current[0]][current[1]]; // 현재칸 먼지 저장
            map[current[0]][current[1]] = moveDust;
            moveDust = temp;
        }

    }

    private static int countDust() {
        int count = 0;
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (map[r][c] > 0)
                    count += map[r][c];
            }
        }
        return count;
    }

    private static class Dust {
        int row;
        int col;
        int value;

        public Dust(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }
}