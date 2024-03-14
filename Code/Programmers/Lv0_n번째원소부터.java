package Programmers;

/**
 * @title Lv0 홀짝구분하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/181944
 * @date 2024.03.14
 * @notes - Java 문법 공부용 <br>
 */

class Lv0_n번째원소부터 {

    public static void main(String[] args) {
    }

    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n + 1];
        int ai = 0;
        for (int idx = n - 1; idx < num_list.length; idx++) {
            answer[ai++] = num_list[idx];
        }
        return answer;
    }

}


