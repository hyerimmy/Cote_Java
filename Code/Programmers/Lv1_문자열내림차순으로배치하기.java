package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @title Lv1 문자열 내림차순으로 배치하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12917
 * @date 2024.03.18
 * @notes - 쉬운문제 - 1번에 통과<br>
 */

class Lv1_문자열내림차순으로배치하기 {
    public static void main(String[] args) {
    }

    public String solution(String s) {
        List<C> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            list.add(new C(s.charAt(i)));
        }

        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        for (C c : list) {
            answer.append(c.data);
        }
        return answer.toString();
    }

    private static class C implements Comparable<C> {
        char data;

        public C(char data) {
            this.data = data;
        }

        @Override
        public int compareTo(C c) {
            return (int) c.data - (int) this.data;
        }
    }


}


