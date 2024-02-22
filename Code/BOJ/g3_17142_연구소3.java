package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.22
 * @notes - BT + BFS로 풀어보자! <br>
 */

public class g3_17142_연구소3 {
    public static int N, M;
    public static int[][] map;
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
                System.out.println(Arrays.toString(activeVirusA));
                minTime = Math.min(minTime, getTime());
                continue;
            }
            selectActiveVirus(depth + 1, idx + 1);
        }
    }

    private static int getTime() {
        boolean[][] isVirus = new boolean[N][N];

        // 초기 바이러스로 초기화
        for (int[] virus : virusList)
            return 0;
    }
}