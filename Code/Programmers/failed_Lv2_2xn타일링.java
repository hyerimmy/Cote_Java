package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12900
 * @date 2024.02.29
 * @notes - 시간초과 <br/>
 */

class failed_Lv2_2xn타일링 {
    public static void main(String[] args) {
    }

    public static int answer = 0;

    public static int solution(int n) {
        getCnt(n);
        return answer % 1000000007;
    }

    public static void getCnt(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while (!queue.isEmpty()) {
            int size = queue.poll();
            if (size < 2) answer++;
            else {
                queue.offer(size - 1);
                queue.offer(size - 2);
            }
        }
    }


}


