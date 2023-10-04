package Programmers;

import java.util.HashMap;

/**
 * @title Lv1 성격 유형 검사하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * @date 2023.10.04
 * @notes
 * - 정답률 48%<br>
 * */

class Lv1_성격유형검사하기 {
    public static void main(String[] args) {
    }

    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> countScore = new HashMap<>();
        countScore.put('R',0);
        countScore.put('T',0);
        countScore.put('C',0);
        countScore.put('F',0);
        countScore.put('J',0);
        countScore.put('M',0);
        countScore.put('A',0);
        countScore.put('N',0);

        for(int i=0; i<survey.length; i++){
            switch(choices[i]){
                case 1: countScore.put(survey[i].charAt(0), countScore.get(survey[i].charAt(0))+3); break;
                case 2: countScore.put(survey[i].charAt(0), countScore.get(survey[i].charAt(0))+2); break;
                case 3: countScore.put(survey[i].charAt(0), countScore.get(survey[i].charAt(0))+1); break;
                case 4: break;
                case 5: countScore.put(survey[i].charAt(1), countScore.get(survey[i].charAt(1))+1); break;
                case 6: countScore.put(survey[i].charAt(1), countScore.get(survey[i].charAt(1))+2); break;
                case 7: countScore.put(survey[i].charAt(1), countScore.get(survey[i].charAt(1))+3); break;
            }
        }

        String answer = "";
        char[][] types = {{'R','T'},{'C','F'},{'J','M'},{'A','N'}};
        for(char[] T : types){
            if(countScore.get(T[0])>=countScore.get(T[1])) answer+=T[0];
            else answer+=T[1];
        }

        return answer;
    }


}


