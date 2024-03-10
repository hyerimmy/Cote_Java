package Programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12946
 * @date 2024.03.10
 * @notes - 한번에 풀었지롱~ <br>
 */

class Lv2_하노이탑 {

    public static List<int[]> answerL = new ArrayList<>();

    public static void main(String[] args) {
    }

    private static void hanoi(int start, int end, int temp, int count) {
        if (count == 2) {
            answerL.add(new int[]{start, temp});
            answerL.add(new int[]{start, end});
            answerL.add(new int[]{temp, end});
            return;
        }

        hanoi(start, temp, end, count - 1);
        answerL.add(new int[]{start, end});
        hanoi(temp, end, start, count - 1);
    }

    public int[][] solution(int n) {
        hanoi(1, 3, 2, n);

        int[][] answerA = new int[answerL.size()][2];
        for (int i = 0; i < answerL.size(); i++) {
            answerA[i] = answerL.get(i);
        }
        return answerA;
    }

}


