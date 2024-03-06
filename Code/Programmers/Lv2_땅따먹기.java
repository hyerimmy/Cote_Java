package Programmers;

/**
 * @title Lv2 땅따먹기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12913#
 * @date 2024.03.06.
 * @notes - 한번에통과 (성공) <br>
 * - 테스트 케이스 다양하게 만들어보는 연습 했다 <br>
 */

class Lv2_땅따먹기 {

    public static void main(String[] args) {
    }

    public static int[][] dp;

    int solution(int[][] land) {

        // 테스트용
        // land = new int[100000][4];
        // for(int row = 0; row < 100000; row++){
        //     for(int col = 0; col < 4; col++){
        //         land[row][col] = col+1;
        //     }
        // }


        int N = land.length;
        dp = new int[N][4];
        int answer = 0;

        // DP 탐색
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < 4; col++) {
                if (row == 0) {
                    dp[row][col] = land[row][col];
                } else {
                    dp[row][col] = getPrevMax(row, col) + land[row][col];
                }
            }
            // System.out.println(Arrays.toString(dp[row]));
        }

        // 정답 도출
        for (int col = 0; col < 4; col++) {
            answer = Math.max(answer, dp[N - 1][col]);
        }

        return answer;
    }

    private static int getPrevMax(int row, int col) {
        int max = 0;

        for (int prevCol = 0; prevCol < 4; prevCol++) {
            if (col != prevCol)
                max = Math.max(dp[row - 1][prevCol], max);
        }

        return max;
    }

}


