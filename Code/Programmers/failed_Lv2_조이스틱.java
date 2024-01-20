package Programmers;

import java.util.*;

/**
 * @title Lv2 소수찾기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * @date 2024.01.18
 * @notes - 그리디 고득점 kit <br>
 * - 왼쪽, 오른쪽 이동 카운팅 시 경우의 수 누락!!!!!!! <br>
 */

class failed_Lv2_조이스틱 {
    public static void main(String[] args) {
    }

    public int solution(String name) {
        int answer = 0;
        List<Integer> changePoint = new ArrayList<>();
        for (int i = 0; i < name.length(); i++) {
            // 변경할 필요 없다면 건너뛰기
            if (name.charAt(i) == 'A')
                continue;

            // 변경시점 모두 저장
            if (i != 0)
                changePoint.add(i);

            // 위 아래 카운트
            int upCount = (int) name.charAt(i) - 65;
            int downCount = 91 - (int) name.charAt(i);
            answer += Math.min(upCount, downCount);
        }

        // 왼쪽 오른쪽 카운트
        Collections.sort(changePoint);
        if (changePoint.size() > 0) {
            int leftCount = name.length() - changePoint.get(0);
            int rightCount = changePoint.get(changePoint.size() - 1);
            answer += Math.min(leftCount, rightCount);
        }

        return answer;
    }
}


