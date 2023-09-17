package Programmers;

import java.util.Scanner;

/**
 * @title Lv0 문자열 섞기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/181942
 * @date 2023.09.16
 * @notes
 * - Java 문법 공부용, 푼 문제중 한 개만 git에 등록 <br>
 * */

class Lv0_문자열섞기 {
    public static void main(String[] args) {
    }

    public static String solution(String str1, String str2) {
        String answer = "";
        for(int i=0; i<str1.length();i++){
            answer += str1.charAt(i);
            answer += str2.charAt(i);
        }
        return answer;
    }

}


