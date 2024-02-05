package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.05
 * @notes - 완전 빡구현이라 오타가 있었음!!! 항상 이런 빡구현 + 코드 길이 긴 거는 꼼꼼히 확인하고 제출하기
 */

public class g4_15683_감시 {
    public static int N, M; // 세로, 가로 크기
    public static int[][] room; // 사무실 칸 정보
    public static boolean[][] watch; // cctv 감시 정보
    public static List<CCTV> cctvList = new ArrayList<>(); // CCTV 리스트
    public static int hiddenCount = 0; // 사각시대 칸 개수
    public static int minHiddenCount; // 사각시대 최소 칸 개수 (결과)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        watch = new boolean[N][M];

        // 사무실 정보 입력받기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                room[n][m] = Integer.parseInt(st.nextToken());

                if (room[n][m] == 0) // 사각시대 초기값 카운팅
                    hiddenCount++;

                if (room[n][m] >= 1 && room[n][m] <= 5) // cctv list 정의
                    cctvList.add(new CCTV(new int[]{n, m}, room[n][m]));
            }
        }

        minHiddenCount = hiddenCount;

        // 백트래킹
        if (cctvList.size() >= 1)
            setCCTV(0);

        // 결과출력
        System.out.println(minHiddenCount);
    }

    private static void setCCTV(int cctvIdx) {
        // 마지막 cctv까지 했다면 결과값 갱신하고 종료
        if (cctvIdx == cctvList.size()) {
//            System.out.println("--" + hiddenCount);
            minHiddenCount = Math.min(minHiddenCount, hiddenCount);
            return;
        }

        CCTV cctv = cctvList.get(cctvIdx);

        if (cctv.type == 1) { // 1번 CCTV
            // (1) 위
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, false, false, false);

            // (2) 오른쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, false, true, false);

            // (3) 아래
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, true, false, false);

            // (4) 왼쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, false, false, true);
        } else if (cctv.type == 2) { // 2번 CCTV
            // (1) 위 & 아래
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, true, false, false);

            // (2) 왼쪽 & 오른쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, false, true, true);
        } else if (cctv.type == 3) { // 3번 CCTV
            // (1) 위 & 오른쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, false, true, false);

            // (2) 오른쪽 & 아래
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, true, true, false);

            // (3) 아래 & 왼쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, true, false, true);

            // (4) 왼쪽 & 위
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, false, false, true);
        } else if (cctv.type == 4) { // 4번 CCTV
            // (1) 위 & 오른쪽 & 아래
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, true, true, false);

            // (2) 오른쪽 & 아래 & 왼쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    false, true, true, true);

            // (3) 아래 & 왼쪽 & 위
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, true, false, true);

            // (4) 왼쪽 & 위 & 오른쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, false, true, true);
        } else if (cctv.type == 5) { // 5번 CCTV
            // (1) 위 & 오른쪽 & 아래 & 왼쪽
            setCCTVonDirection(cctvIdx, new int[]{cctv.p[0], cctv.p[1]},
                    true, true, true, true);
        }
    }

    private static void setCCTVonDirection(int cctvIdx, int[] cctvP, boolean up, boolean down, boolean right, boolean left) {
        List<int[]> changePositions = new ArrayList<>();
        if (up) {
            changePositions.addAll(setUp(cctvP));
        }
        if (down) {
            changePositions.addAll(setDown(cctvP));
        }
        if (right) {
            changePositions.addAll(setRight(cctvP));
        }
        if (left) {
            changePositions.addAll(setLeft(cctvP));
        }
        hiddenCount -= changePositions.size();
        setCCTV(cctvIdx + 1);
        setDefault(changePositions);
        hiddenCount += changePositions.size();
    }

    private static void setDefault(List<int[]> changePositions) {
        for (int[] p : changePositions) {
            watch[p[0]][p[1]] = false;
        }
    }

    private static List<int[]> setDown(int[] p) {
        List<int[]> changePositions = new ArrayList<>();
        int[] newP = new int[]{p[0] + 1, p[1]};
        while (newP[0] >= 0 && newP[0] < N && newP[1] >= 0 && newP[1] < M) {
            if (room[newP[0]][newP[1]] == 0 && !watch[newP[0]][newP[1]]) {
                watch[newP[0]][newP[1]] = true;
                changePositions.add(new int[]{newP[0], newP[1]});
            } else if (room[newP[0]][newP[1]] == 6) { // 벽이라면 종료
                break;
            }
            newP[0]++;
        }
        return changePositions;
    }

    private static List<int[]> setUp(int[] p) {
        List<int[]> changePositions = new ArrayList<>();
        int[] newP = new int[]{p[0] - 1, p[1]};
        while (newP[0] >= 0 && newP[0] < N && newP[1] >= 0 && newP[1] < M) {
            if (room[newP[0]][newP[1]] == 0 && !watch[newP[0]][newP[1]]) {
                watch[newP[0]][newP[1]] = true;
                changePositions.add(new int[]{newP[0], newP[1]});
            } else if (room[newP[0]][newP[1]] == 6) { // 벽이라면 종료
                break;
            }
            newP[0]--;
        }
        return changePositions;
    }

    private static List<int[]> setRight(int[] p) {
        List<int[]> changePositions = new ArrayList<>();
        int[] newP = new int[]{p[0], p[1] + 1};
        while (newP[0] >= 0 && newP[0] < N && newP[1] >= 0 && newP[1] < M) {
            if (room[newP[0]][newP[1]] == 0 && !watch[newP[0]][newP[1]]) {
                watch[newP[0]][newP[1]] = true;
                changePositions.add(new int[]{newP[0], newP[1]});
            } else if (room[newP[0]][newP[1]] == 6) { // 벽이라면 종료
                break;
            }
            newP[1]++;
        }
        return changePositions;
    }

    private static List<int[]> setLeft(int[] p) {
        List<int[]> changePositions = new ArrayList<>();
        int[] newP = new int[]{p[0], p[1] - 1};
        while (newP[0] >= 0 && newP[0] < N && newP[1] >= 0 && newP[1] < M) {
            if (room[newP[0]][newP[1]] == 0 && !watch[newP[0]][newP[1]]) {
                watch[newP[0]][newP[1]] = true;
                changePositions.add(new int[]{newP[0], newP[1]});
            } else if (room[newP[0]][newP[1]] == 6) { // 벽이라면 종료
                break;
            }
            newP[1]--;
        }
        return changePositions;
    }

    private static class CCTV {
        public int[] p; // 위치
        public int type; // cctv 타입

        public CCTV(int[] p, int type) {
            this.p = p;
            this.type = type;
        }
    }
}
