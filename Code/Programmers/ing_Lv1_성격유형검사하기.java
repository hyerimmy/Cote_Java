package Programmers;

import java.util.HashMap;

/**
 * @title Lv1 성격 유형 검사하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * @date 2023.10.04
 * @notes
 * - 정답률 48%<br>
 * */

class ing_Lv1_성격유형검사하기 {
    public static void main(String[] args) {
    }

    public static String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> countScore = new HashMap<>();
        countScore.put('R',0);
        System.out.println(countScore);

        for(int C : choices){
            switch(C){
                case 1: System.out.println("1"); break;
            }
        }

        String answer = "";
        return answer;
    }


}


