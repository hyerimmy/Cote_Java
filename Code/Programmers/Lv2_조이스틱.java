package Programmers;

/**
 * @title Lv2 소수찾기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * @date 2024.01.18 / 2024.01.21
 * @notes - 그리디 고득점 kit <br>
 * - 왼쪽, 오른쪽 이동 카운팅 시 경우의 수 누락!!!!!!! <br>
 */

class Lv2_조이스틱 {
    public static void main(String[] args) {
    }

    public int solution(String name) {
        int upDownCount = 0;
        int leftRightCount = name.length() - 1;
        for (int i = 0; i < name.length(); i++){
            // 왼쪽 오른쪽 카운트
            int point = i;
            while (point < name.length()){
                point++;
                if (point == name.length() || name.charAt(point) != 'A'){
                    break;
                }
            }
            int result = i + (name.length() - point) + Math.min(i, (name.length() - point));
            leftRightCount = Math.min(leftRightCount, result);

            // 위 아래 카운트
            int upCount = (int) name.charAt(i) - 65;
            int downCount = 91 - (int) name.charAt(i);
            upDownCount += Math.min(upCount, downCount);
        }

        return upDownCount + leftRightCount;
    }
}


