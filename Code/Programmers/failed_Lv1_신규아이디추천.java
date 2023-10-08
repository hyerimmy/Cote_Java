package Programmers;

import java.util.HashMap;

/**
 * @title Lv1 대충 만든 자판
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * @date 2023.10.05
 * @notes
 * */

class failed_Lv1_신규아이디추천 {
    public static void main(String[] args) {
    }

    public static String solution(String new_id) {
        String answer = "";
        boolean prevEnd = false;
        for(int i=0; i<new_id.length(); i++){
            char C = new_id.charAt(i);
            if(answer.length()==15) break;
            if(C=='.'){
                if(i==0 || i==new_id.length()-1) {
                    prevEnd = true;
                    continue;
                }
                else if(prevEnd) continue;
                else prevEnd = true;
            }
            else{
                prevEnd = false;
                if('A'<=C && C<='Z') C = Character.toLowerCase(C);
                if(!(C=='-' || C=='_' || C=='.' ||
                        ('a'<=C && C<='z') || ('0'<=C && C<='9'))) continue;
            }
            answer += C;
        }
        char lastC = answer.charAt(answer.length()-1);

        if(lastC=='.') answer = answer.substring(0,answer.length()-1);
        if(answer.length()==0) answer = "a";
        lastC = answer.charAt(answer.length()-1);
        if(answer.length()<=2){
            while(answer.length()<3) answer+=lastC;
        }
        return answer;
    }

}


