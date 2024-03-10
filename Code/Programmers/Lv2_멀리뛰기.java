package Programmers;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * @date 2024.03.10
 * @notes - 한번에 풀었지롱~22 <br>
 */

class Lv2_멀리뛰기 {
    public static long DIV_NUM = 1234567;

    public static void main(String[] args) {
    }

    public long solution(int n) {
        long[] dp = new long[2001];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % DIV_NUM;
        }


        return dp[n];
    }

}


