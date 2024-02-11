package Programmers;

/**
 * @title Lv1 대충 만든 자판
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/160586
 * @date 2023.10.05 / 2024.02.11
 * @notes - 정규식을 잘 써야 하는 문제
 * - 정규식 문법, replaceAll 함수 기억하기
 */

class Lv1_신규아이디추천__정규식 {
    public static void main(String[] args) {
    }

    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); // *1단계*

        answer = answer.replaceAll("[^a-z0-9\\_\\-\\.]", ""); // *2단계*

        answer = answer.replaceAll("[\\.]{2,}", "."); // *3단계*

        // *4단계*
        answer = answer.replaceAll("^[\\.]", "");
        answer = answer.replaceAll("[\\.]$", "");

        // *5단계*
        if (answer.isEmpty())
            answer = "a";

        // *6단계*
        if (answer.length() >= 16)
            answer = answer.substring(0, 15).replaceAll("[.]$", "");

        // *7단계*
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }

        return answer;
    }

}


