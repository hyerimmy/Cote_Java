package Programmers;

import java.util.Arrays;

/**
 * @title Lv3 단속카메라
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42884
 * @date 2024.01.29
 * @notes - 프로그래머스 고득점 kit <br>
 */

/*
문제의 해결 원리를 잘만 파악하면 굉장히 쉬운 문제.
해당 유형을 잘 외웠다가 활용할 수 있도록 하기!!!!!!!
*/

class Lv3_단속카메라__그리디 {
    public static void main(String[] args) {
    }

    public int solution(int[][] routes) {
        // 종료 지점 기준으로 오름차순 정렬
        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });

        int cameraCount = 0; // 카메라 개수 결과 저장 변수
        int prevCameraPosition = -30_001; // 가장 최근 카메라 위치 저장 변수

        // 차량 반복하며 모든 차량이 만날 수 있도록 개수 갱신
        for (int[] R : routes) {
            // 만약 이전에 설치한 카메라가 루트 시작점보다 이전에 있다면 새로 설치
            if (prevCameraPosition < R[0]) {
                cameraCount++;
                prevCameraPosition = R[1];
            }
        }

        // 결과값 반환
        return cameraCount;
    }
}


