package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
BFS 완전 탐색 시 시간초과
Queue로 넣어서 탐색하는 것 보다 그냥 단순 반복문으로 처리하는게 시간이 훨씬 줄어든다 - 왜일까?
테스트케이스12번 틀림.. 반례 생각해보기
 */

public class failed_Lv3_나무수확 {
    public static int N;
    public static int[][] map;
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1][2];

        // 씨앗 정보 입력받기
        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 1; col <= N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 탐색 시작
        for (int idxSum = 2; idxSum <= 2 * N; idxSum++) {
            for (int idx = 1; idx <= N; idx++) {
                if (idxSum - idx >= 1 && idxSum - idx <= N)
                    findBestLine(idx, idxSum - idx);
            }
        }

        // Queue<int[]> Q = new LinkedList<>();
        // Q.add(new int[]{1,1});
        // while(!Q.isEmpty()){
        //     int[] p = Q.poll();
        //     findBestLine(p[0], p[1]);

        //     // 이동한 좌표 넣기
        //     if(p[0]+1 <= N && dp[p[0]+1][p[1]][0] == 0){
        //         Q.add(new int[]{p[0]+1, p[1]});
        //     }
        //     if(p[1]+1 <= N && dp[p[0]][p[1]+1][0] == 0){
        //         Q.add(new int[]{p[0], p[1]+1});
        //     }
        // }

        // 결과 출력
        System.out.println(dp[N][N][0] + dp[N][N][1]);
    }

    private static void findBestLine(int row, int col) {
        int case1Sum = dp[row - 1][col][0] + map[row][col]; // 합
        int case1Max = Math.max(dp[row - 1][col][1], map[row][col]); // 최대값

        int case2Sum = dp[row][col - 1][0] + map[row][col]; // 합
        int case2Max = Math.max(dp[row][col - 1][1], map[row][col]); // 최대값

        if (case1Sum + case1Max > case2Sum + case2Max) {
            dp[row][col][0] = case1Sum; // 합
            dp[row][col][1] = case1Max; // 최대값
        } else if (case1Sum + case1Max < case2Sum + case2Max) {
            dp[row][col][0] = case2Sum; // 합
            dp[row][col][1] = case2Max; // 최대값
        } else if (case1Sum > case2Sum) {
            dp[row][col][0] = case1Sum; // 합
            dp[row][col][1] = case1Max; // 최대값
        } else if (case1Sum <= case2Sum) {
            dp[row][col][0] = case2Sum; // 합
            dp[row][col][1] = case2Max; // 최대값
        }
        // System.out.println("("+row+", "+col+"), "+map[row][col]+" = "+dp[row][col][0]+" + "+dp[row][col][1]);
    }


    // private static void BFS(){
    //     Queue<WaterLine> Q = new LinkedList<>();

    //     // 초기값 넣기
    //     Q.add(new WaterLine(0,  0, map[0][0], map[0][0]));

    //     while(!Q.isEmpty()){
    //         WaterLine WL = Q.poll();

    //         // 만약 끝점에 도착했다면 answer 업데이트
    //         if(WL.row == N - 1 && WL.col == N - 1){
    //             answer = Math.max(answer, WL.sum + WL.max);
    //             continue;
    //         }

    //         // #1. 만약 좌표를 벗어나지 않는다면 오른쪽으로 이동
    //         if(WL.col + 1 < N){
    //             Q.add(new WaterLine(
    //                 WL.row,
    //                 WL.col + 1,
    //                 Math.max(WL.max, map[WL.row][WL.col + 1]),
    //                 WL.sum + map[WL.row][WL.col + 1]
    //             ));
    //         }

    //         // #2. 만약 좌표를 벗어나지 않는다면 아래쪽으로 이동
    //         if(WL.row + 1 < N){
    //             Q.add(new WaterLine(
    //                 WL.row + 1,
    //                 WL.col,
    //                 Math.max(WL.max, map[WL.row + 1][WL.col]),
    //                 WL.sum + map[WL.row + 1][WL.col]
    //             ));
    //         }
    //     }

    // }

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
