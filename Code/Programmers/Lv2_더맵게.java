package Programmers;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * @title Lv2 더맵게
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42626
 * @date 2024.01.17
 * @notes - 힙 <br>
 * - 예외처리 제대로 못함. (0 반환인 경우, 즉 처음부터 완성형인 경우) <br>
 */

class Lv2_더맵게 {
    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"},{"HND", "IAD"},{"JFK", "HND"}};
//        System.out.println(Arrays.toString(solution(tickets)));

        int[][] rectangle = {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}};
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> PQ = new PriorityQueue<>();

        // 초기값 입력
        for (int number : scoville) {
            PQ.add(number);
        }

        int scovilleNum = 0;// 스코빌 지수 정의
        int answer = 0; // 섞는 횟수

        // 이미 조건에 부합한다면 0 반환
        if (PQ.peek() >= K)
            return 0;

        // 스코빌 지수 업데이트
        while (PQ.size() >= 2) {
            // 음식 섞어서 넣기
            answer++;
            PQ.add(PQ.poll() + (PQ.poll() * 2));

            // 스코빌 지수 확인하기
            if (PQ.peek() >= K)
                return answer;
        }

        return -1;
    }

}

