package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.01.06
 * @notes - 나는 코더다 대회 <br>
 * - 메모리 초과, 문제 공개되면 다시 수정해보기.
 */

public class _contest_31027_물고기게임 {
    public static int N;
    public static int[][] fish;
    public static int[] dI = new int[]{0, 0, 1, -1};
    public static int[] dJ = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // 인구 수 입력받기
        fish = new int[2][N];
        int totalFish = 0;
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                fish[i][j] = Integer.parseInt(st.nextToken());
                totalFish += fish[i][j];
            }
        }

        int[] daveP = new int[]{0, 0};
        int[] autoP = new int[]{1, N - 1};

        int daveF = 0;
        int autoF = 0;

        while (daveF + autoF < totalFish) {
            int[] bestP = getBestPosition(daveP);
            daveF += fish[bestP[0]][bestP[1]];
            fish[bestP[0]][bestP[1]] = 0;
            daveP = bestP;

            bestP = getBestPosition(autoP);
            autoF += fish[bestP[0]][bestP[1]];
            fish[bestP[0]][bestP[1]] = 0;
            autoP = bestP;
        }

        System.out.println(daveF + " " + autoF);


    }

    public static int[] getBestPosition(int[] P) {
        int[] bestP = new int[2];
        int maxFish = 0;

        for (int t = 0; t < 4; t++) {
            int[] newP = new int[]{P[0] + dI[t],P[1] + dJ[t]};

            // 범위 벗어난다면 뛰어넘기
            if (newP[0] < 0 || newP[0] >= N || newP[1] < 0 || newP[1] >= N)
                continue;

            // 최대 물고기수, 최적 위치 업데이트
            if(maxFish < fish[newP[0]][newP[1]]){
                maxFish = fish[newP[0]][newP[1]];
                bestP = newP;
            }
        }

        return bestP;
    }
}