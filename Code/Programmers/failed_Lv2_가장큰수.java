package Programmers;

import java.util.Arrays;

/**
 * @title Lv2 가장큰수
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * @date 2023.09.06
 * @notes
 * - 정렬 프로그래머스 고득점 kit<br>
 * */

class failed_Lv2_가장큰수 {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        System.out.println(solution(numbers));

        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }

    public static String solution(int[] numbers) {
        String[] N = new String[numbers.length];
        for (int i=0; i<N.length;i++){
            N[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(N);

        String answer = "";
        for (int i=N.length-1; i>=0;i--){
            answer = answer + N[i];
        }
        return answer;
    }


}


