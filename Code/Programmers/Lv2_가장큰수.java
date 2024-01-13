package Programmers;

import java.util.Arrays;

/**
 * @title Lv2 가장큰수
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * @date 2023.09.06 / 2024.01.13
 * @notes
 * - 정렬 프로그래머스 고득점 kit<br>
 * */

class Lv2_가장큰수 {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        System.out.println(solution(numbers));

        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        // 문자열 배열 정의
        String[] stringNumbers = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            stringNumbers[i] = Integer.toString(numbers[i]);
        }

        // numbers 정렬
        Arrays.sort(stringNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 정렬한 순서대로 합치기
        StringBuilder answer = new StringBuilder();
        for(String n : stringNumbers){
            answer.append(n);
        }

        // 모두 0이라면 0으로 반환 (예. [0,0,0] -> 000 -> 0)
        if(stringNumbers[0].equals("0"))
            return "0";

        return answer.toString();
    }
}
