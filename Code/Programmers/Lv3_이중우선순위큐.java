package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @title Lv3 이중우선순위큐
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * @date 2024.01.26
 * @notes
 * - 프로그래머스 고득점 kit<br>
 * */

/*
- PriorityQueue 정의 문법 익히기
*/

class Lv3_이중우선순위큐 {
    public static void main(String[] args) {
    }

    public int[] solution(String[] operations) {
        PriorityQueue<Integer> PQmin = new PriorityQueue<>();
        PriorityQueue<Integer> PQmax = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> count = new HashMap<>();
        int totalSize = 0;

        for(String operation : operations){
            String[] O = operation.split(" ");
            String order = O[0];
            int number = Integer.parseInt(O[1]);

            // 숫자 삽입
            if(order.equals("I")){
                PQmax.add(number);
                PQmin.add(number);
                // System.out.println("+ "+number);

                // 카운팅 업데이트
                count.put(number, count.getOrDefault(number, 0) + 1);

                // 개수 업데이트
                totalSize++;
            }

            // 숫자 삭제
            if(order.equals("D")){
                // 큐에 숫자가 없다면 건너뛰기
                if(totalSize <= 0)
                    continue;

                if(number == 1){
                    // 최대값 삭제, 카운팅 업데이트
                    int pollNumber = PQmax.poll();
                    count.put(pollNumber, count.get(pollNumber) - 1);
                    // System.out.println("- "+pollNumber+" (max)");
                } else if (number == -1){
                    // 최소값 삭제, 카운팅 업데이트
                    int pollNumber = PQmin.poll();
                    count.put(pollNumber, count.get(pollNumber) - 1);
                    // System.out.println("- "+pollNumber+" (min)");
                }

                // 개수 업데이트
                totalSize--;
            }
        }
        int[] answer = new int[2];

        // 큐가 비어있다면 [0,0] 반환
        if(totalSize == 0)
            return answer;

        // 큐가 비어있지 않다면 최대값, 최소값 넣기
        while(!PQmax.isEmpty()){
            int pollNumber = PQmax.poll();

            if(count.get(pollNumber) > 0){
                answer[0] = pollNumber;
                break;
            }
        }

        while(!PQmin.isEmpty()){
            int pollNumber = PQmin.poll();

            if(count.get(pollNumber) > 0){
                answer[1] = pollNumber;
                break;
            }
        }

        return answer;
    }
}
