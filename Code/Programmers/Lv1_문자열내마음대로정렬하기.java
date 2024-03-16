package Programmers;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @title Lv1 문자열내마음대로정렬하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12915
 * @date 2024.03.16 sat
 * @notes - <br>
 */

class Lv1_문자열내마음대로정렬하기 {
    public static int N;

    public static void main(String[] args) {
    }

    public String[] solution(String[] strings, int n) {
        N = n;

        List<Word> words = new ArrayList<>();
        for (int idx = 0; idx < strings.length; idx++) {
            words.add(new Word(idx, strings[idx]));
        }

        Collections.sort(words);

        String[] answer = new String[strings.length];
        for (int idx = 0; idx < strings.length; idx++) {
            answer[idx] = words.get(idx).data;
        }
        return answer;
    }

    private static class Word implements Comparable<Word> {
        int idx;
        String data;

        public Word(int idx, String data) {
            this.idx = idx;
            this.data = data;
        }

        @Override
        public int compareTo(Word word) {
            if (this.data.charAt(N) != word.data.charAt(N))
                return this.data.charAt(N) - word.data.charAt(N);
            return this.data.compareTo(word.data);
        }

    }

}


