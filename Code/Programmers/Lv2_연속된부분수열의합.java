package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title Lv0 홀짝구분하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/181917
 * @date 2023.09.29
 * @notes - Java 문법 공부용 <br>
 */

class Lv2_연속된부분수열의합 {

    public static void main(String[] args) {
    }

    public int[] solution(int[] sequence, int k) {
        Queue<Integer> idxQ = new LinkedList<>();
        int sum = 0;
        int[] answer = new int[2];
        boolean find = false;

        for (int idx = 0; idx < sequence.length; idx++) {
            idxQ.add(idx);
            sum += sequence[idx];

            while (sum > k && !idxQ.isEmpty()) {
                sum -= sequence[idxQ.poll()];
            }

            // 처음 찾은 부분수열이거나 길이가 더 짧다면
            if (sum == k && (!find || (answer[1] - answer[0] + 1) > idxQ.size())) {
                answer[0] = idxQ.peek();
                answer[1] = idx;
                find = true;
            }
        }

        return answer;
    }
}


