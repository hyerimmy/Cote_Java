package Programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * @title 체육복
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * @date 2024.01.17
 * @notes - 그리디 <br>
 * - [빠뜨린 조건] 여벌 체육복이 있는 학생도 도난당할 수 있습니다. <br>
 */

class Lv1_체육복 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        // 도난당한 학생 boolean 배열로 저장
        boolean[] lostA = new boolean[n + 2];
        for (int l : lost) {
            lostA[l] = true;
        }

        // 여벌 체육복 학생 boolean 배열로 저장
        boolean[] reserveA = new boolean[n + 2];
        for (int r : reserve) {
            reserveA[r] = true;
        }

        // 도난당한 학생 수 저장
        int lostCount = lost.length;

        // 도난당한 학생에게 체육복 빌려줌
        for (int i = 1; i <= n; i++) {
            if (!lostA[i]) // 도난당하지 않았다면 건너뜀
                continue;

            if (reserveA[i]) { // 본인이 여벌 있다면 사용
                reserveA[i] = false;
                lostCount--;
            } else if (reserveA[i - 1]) { // 왼쪽에 여벌 있다면 사용
                reserveA[i - 1] = false;
                lostCount--;
            } else if (reserveA[i + 1] && !lostA[i + 1]) { // 오른쪽에 여벌 있다면 사용 ( + 오른쪽 도난X)
                reserveA[i + 1] = false;
                lostCount--;
            }
        }

        // 결과 반환
        return n - lostCount;
    }
}


