package Programmers;

import java.util.Arrays;
import java.util.Stack;

/**
 * @title Lv2 주식가격
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * @date 2024.01.25
 * @notes
 * - 프로그래머스 고득점 kit<br>
 * */

class Lv2_주식가격 {
    public static void main(String[] args) {
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for(int idx = 0; idx < prices.length; idx++){
            // 현재 가격보다 큰 경우 스택에서 제거하기
            while(!stack.isEmpty() && prices[stack.peek()] > prices[idx]){
                int popIdx = stack.pop();
                answer[popIdx] = idx - popIdx;
            }

            // 현재 가격 인덱스 넣기
            stack.push(idx);
        }

        // 마지막까지 스택에 남아있는 가격 인덱스 처리
        while(!stack.isEmpty()){
            int popIdx = stack.pop();
            answer[popIdx] = prices.length - 1 - popIdx;
            // System.out.println(popIdx);
        }

        return answer;
    }
}
