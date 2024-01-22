package Programmers;

import java.util.Arrays;

/**
 * @title Lv2 구명보트
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * @date 2024.01.22
 * @notes
 * - 고득점 kit - 그리디 <br>
 * - 시간초과 : O(n^2)으로 풀 필요가 없었다. left, right로 하나씩 지워가는 방식으로 짠다면 O(n)! 명심하기<br>
 * */

class Lv2_구명보트 {

    public static void main(String[] args) {
    }

    public int solution(int[] people, int limit) {
        // 사람 몸무게 순으로 정렬
        Arrays.sort(people);

        int answer = 0; // 반환할 구명보트 개수
        int leftIdx = 0; // 이동할 왼쪽 사람 인덱스
        int rightIdx = people.length - 1; // 이동할 오른쪽 사람 인덱스

        // 구명보트로 이동 반복
        while(leftIdx <= rightIdx){
            int weight = people[rightIdx--];
            if(people[leftIdx] + weight <= limit){
                leftIdx++;
            }
            answer++;
        }

        // 결과 반환
        return answer;
    }

}


