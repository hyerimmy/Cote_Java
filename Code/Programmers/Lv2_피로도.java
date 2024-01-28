package Programmers;

import java.util.Arrays;

/**
 * @title Lv2 피로도
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * @date 2024.01.28
 * @notes - 프로그래머스 고득점 kit <br>
 */

class Lv2_피로도 {
    public static void main(String[] args) {
    }

    public static int answer = 0;
    public static int[][] D;

    // BF
    public static int count = 0; // 던전 카운팅
    public static int gage = 0; // 피로도
    public static boolean[] selected; // 방문 구분

    public int solution(int k, int[][] dungeons) {
        D = dungeons;
        gage = k;
        selected = new boolean[dungeons.length];

        selectDungeons();

        return answer;
    }

    private void selectDungeons() {
        answer = Math.max(answer, count);

        for (int idx = 0; idx < D.length; idx++) {
            // 최소 필요 피로도보다 적거나, 이미 선택된 던전이라면 건너뜀
            if (D[idx][0] > gage || selected[idx])
                continue;

            // 해당 던전 선택해 재귀
            count++;
            gage -= D[idx][1];
            selected[idx] = true;

            selectDungeons();

            count--;
            gage += D[idx][1];
            selected[idx] = false;
        }
    }
}


