package Programmers;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12900
 * @date 2024.02.29
 * @notes - 시간초과 -> 전형적인 DP 문제 <br/>
 */

class Lv2_2xn타일링 {
    public static void main(String[] args) {
        System.out.println(solution(4));
    }

    public static int[] dp;
    public static int UNIT = 1000000007;

    public static int solution(int n) {
        // dp 배열 정의
        dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        // dp 수 채우기 (경우의수 계산)
        for (int i = 2; i < n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % UNIT;
        }

//        System.out.println(Arrays.toString(dp));

        // 결과 출력
        return dp[n - 1];
    }


}


