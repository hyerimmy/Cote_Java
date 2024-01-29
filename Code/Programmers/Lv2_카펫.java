package Programmers;

/**
 * @title Lv2 피로도
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42842
 * @date 2024.01.29
 * @notes - 프로그래머스 고득점 kit <br>
 */

class Lv2_카펫 {
    public static void main(String[] args) {
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int sum = brown + yellow;
        for (int height = 3; height <= sum; height++) {
            // 세로 길이 조건에 부합하지 않으면 건너뜀
            if (sum % height != 0)
                continue;

            // 가로 길이 계산
            int width = sum / height;

            // 카펫으로 적합한지 확인
            if ((height - 2) * (width - 2) == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
            }
        }
        return answer;
    }
}


