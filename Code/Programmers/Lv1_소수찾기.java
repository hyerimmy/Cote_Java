package Programmers;

import java.util.Arrays;

/**
 * @title Lv1 소수찾기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12921
 * @date 2024.03.13
 * @notes - 소수 찾기 <br>
 */

class Lv1_소수찾기 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        boolean[] isSosu = new boolean[n + 1];
        Arrays.fill(isSosu, true);
        isSosu[0] = false;
        isSosu[1] = false;

        for (int nn = 2; nn <= Math.sqrt(n); nn++) {
            for (int k = 2; nn * k <= n; k++) {
                isSosu[nn * k] = false;
            }
        }
        // System.out.println(Arrays.toString(isSosu));

        // 소수 개수 카운팅
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            if (isSosu[i]) answer++;
        }

        return answer;
    }

}


