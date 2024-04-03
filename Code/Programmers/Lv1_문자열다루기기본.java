package Programmers;

/**
 * @title Lv0 홀짝구분하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/181917
 * @date 2023.09.29
 * @notes - Java 문법 공부용 <br>
 */

class Lv1_문자열다루기기본 {

    public static void main(String[] args) {
    }

    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) < 48 || (int) s.charAt(i) > 57) {
                return false;
            }
        }

        return true;
    }

}


