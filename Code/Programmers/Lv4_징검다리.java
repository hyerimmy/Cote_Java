package Programmers;

import java.util.Arrays;


/**
 * @title Lv4 징검다리
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/43236
 * @date 2024.01.16
 * @notes - 이분탐색 활용 문제!! 익혀두기 <br>
 * - 틀린 이유 1 : 마지막돌 ~ 도착지점 거리 계산 누락 <br>
 * - 틀린 이유 2 : left, right 범위 설정 오류 (right != 마지막돌, right = distance) <br>
 */

class Lv4_징검다리 {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }

    public static int solution(int distance, int[] rocks, int n) {
        // 돌 거리순으로 정렬
        Arrays.sort(rocks);

        // 이진탐색 위해 값 설정
        int left = 1;
        int right = distance;

        // 정답값 변수 정의
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // 타겟으로 설정한 거리가 정답일 경우 제거해야 하는 바위돌 개수 계산
            int removeCount = 0;
            // #1. 출발지점 ~ 마지막돌
            int start = 0;
            for (int rock : rocks) {
                if (rock - start < mid) {
                    // 타겟으로 설정한 거리보다 작은 거리를 가진 경우 돌 제거
                    if (++removeCount > n)
                        break;
                } else {
                    // 타겟으로 설정한 거리보다 크거나 같은 경우 거리 시작점 갱신
                    start = rock;
                }
            }
            // #2. 마지막돌 ~ 도착지점
            if (distance - start < mid) {
                removeCount++;
            }

            // 계산한 바위돌 개수로 이진탐색 범위 갱신
            if (removeCount > n) {
                // 더 많이 제거했다면
                right = mid - 1;
            } else if (removeCount <= n) {
                // 덜 제거했다면 (알맞게 제거했더라도 최대값을 위해 계속 계산)
                answer = mid;
                left = mid + 1;
            }

        }

        return answer;
    }

}

