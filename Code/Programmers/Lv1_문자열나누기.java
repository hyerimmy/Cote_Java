package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @title Lv1 K번째수
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12198
 * @date 2023.09.06
 * @notes
 * - 정렬 프로그래머스 고득점 kit<br>
 * */

class Lv1_문자열나누기 {
    public static void main(String[] args) {
    }

    public static int solution(String s) {
        int answer = 1;

        char startC = s.charAt(0);
        int cnt = 1;
        // System.out.println("---"+s.charAt(0));
        // System.out.println(startC+"/"+cnt);
        for(int i=1; i<s.length();i++){
            if(cnt==0) {
                // System.out.println("A"+answer);
                answer++;
                startC = s.charAt(i);
                cnt = 1;
            }
            else{
                if(s.charAt(i)==startC) cnt++;
                else cnt--;
            }

            // System.out.println("---"+s.charAt(i));
            // System.out.println(startC+"/"+cnt);
        }
        return answer;
    }


}


