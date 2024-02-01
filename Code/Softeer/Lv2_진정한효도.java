package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lv2_진정한효도 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지형 입력받기
        int[][] map = new int[3][3];
        for (int row = 0; row < 3; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < 3; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 최소비용
        int minCost = 10; // 불가능한 큰 값으로 초기화

        // 가로 한 줄이 동일한 경우
        for (int row = 0; row < 3; row++) {
            for (int height = 1; height <= 3; height++) {
                int cost = Math.abs(map[row][0] - height)
                        + Math.abs(map[row][1] - height)
                        + Math.abs(map[row][2] - height);

                // 평탄화에 가장 적게 드는 비용으로 결과값 업데이트
                minCost = Math.min(minCost, cost);
            }
        }

        // 세로 한 줄이 동일한 경우
        for (int col = 0; col < 3; col++) {
            for (int height = 1; height <= 3; height++) {
                int cost = Math.abs(map[0][col] - height)
                        + Math.abs(map[1][col] - height)
                        + Math.abs(map[2][col] - height);

                // 평탄화에 가장 적게 드는 비용으로 결과값 업데이트
                minCost = Math.min(minCost, cost);
            }
        }

        System.out.println(minCost);
    }
}
