package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.22
 * @notes - BT + BFS로 풀어보자! <br>
 * - 예제 5번부터 이상함.. -> 탐색불가할 경우 -1 처리 안해서!!
 */

public class g3_17142_연구소3 {
    public static int N, M;
    public static int[][] map;
    public static int wallCount = 0;
    public static List<int[]> virusList = new ArrayList<>();
    public static int[] activeVirusA;
    public static int[] dR = new int[]{0, 0, 1, -1};
    public static int[] dC = new int[]{1, -1, 0, 0};

    public static int MAX = Integer.MAX_VALUE;
    public static int minTime = MAX;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        activeVirusA = new int[M];

        // 지도 정보 입력받기
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
                if (map[row][col] == 2)
                    virusList.add(new int[]{row, col});
                else if (map[row][col] == 1)
                    wallCount++;
            }
        }

        // 바이러스 중 활성 바이러스 M개 선택하기
        selectActiveVirus(0, 0);

        // 결과 출력
        if (minTime == MAX)
            minTime = -1;
        System.out.println(minTime);
    }

    private static void selectActiveVirus(int depth, int startVirus) {
        for (int idx = startVirus; idx < virusList.size(); idx++) {
            activeVirusA[depth] = idx;
            if (depth == M - 1) {
                // 바이러스 퍼뜨림 탐색
//                System.out.println(Arrays.toString(activeVirusA));
                int time = getTime();
                if (time != -1)
                    minTime = Math.min(minTime, time);
                continue;
            }
            selectActiveVirus(depth + 1, idx + 1);
        }
    }

    private static int getTime() {
        int[][] virusTime = new int[N][N];
        int virusCount = virusList.size();
        int time = 0;

        // 시간 -1로 전체 초기화
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                virusTime[r][c] = -1;
            }
        }

        // 활성 바이러스 시간 0으로 초기화
        for (int v : activeVirusA) {
            int[] activeV = virusList.get(v);
            virusTime[activeV[0]][activeV[1]] = 0;
        }

        // Q 초기화
        Queue<int[]> Q = new LinkedList<>();
        for (int activeVirusIdx : activeVirusA) {
            Q.add(virusList.get(activeVirusIdx));
        }


        // BFS
        while (!Q.isEmpty()) {
            int[] p = Q.poll();

            // 바이러스 모두 확산되었다면 종료
            if (virusCount + wallCount == N * N)
                break;

            // 주변 칸 탐색
            for (int t = 0; t < 4; t++) {
                int newR = p[0] + dR[t];
                int newC = p[1] + dC[t];

                // 범위 벗어난다면 건너뜀
                if (newR < 0 || newR >= N || newC < 0 || newC >= N)
                    continue;

                // 이미 탐색한 곳이라면 건너뜀
                if (virusTime[newR][newC] >= 0)
                    continue;

                // 빈칸, 비활성 바이러스일 경우 바이러스 복제
                if (map[newR][newC] == 0 || map[newR][newC] == 2) {
                    virusTime[newR][newC] = virusTime[p[0]][p[1]] + 1;
                    Q.add(new int[]{newR, newC});
                    time = virusTime[newR][newC];
                }

                // 바이러스 카운팅
                if (map[newR][newC] == 0) { // 빈칸이라면
                    virusCount++;
                }
            }
        }

        // 테스트 출력
//        for (int row = 0; row < N; row++) {
//            System.out.println(Arrays.toString(virusTime[row]));
//        }
//        System.out.println(">>> time : " + time);

        if (virusCount + wallCount != N * N)
            time = -1;
        return time;
    }
}