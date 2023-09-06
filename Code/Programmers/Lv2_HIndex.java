package Programmers;

import java.util.Arrays;

/**
 * @title Lv2 H-Index
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42747
 * @date 2023.09.06
 * @notes
 * - 정렬 프로그래머스 고득점 kit<br>
 * */

class Lv2_HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    public static int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        int startIdx = 0;
        for (int i=0; i<citations[citations.length-1]; i++){
            while(citations[startIdx]<i) startIdx++;
            if(i<=(citations.length-startIdx)){
                answer = i;
            }
            else break;
        }
        return answer;
    }


}


