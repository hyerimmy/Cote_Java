package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @title Lv1 모의고사
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * @date 2024.01.24.
 * @notes
 * - 프로그래머스 고득점 kit - 완전탐색<br>
 * */

class Lv1_모의고사 {
    public static void main(String[] args) {
    }

    public int[] solution(int[] answers) {
        List<List<Integer>> pattern = new ArrayList<>();
        pattern.add(List.of(1,2,3,4,5));
        pattern.add(List.of(2,1,2,3,2,4,2,5));
        pattern.add(List.of(3,3,1,1,2,2,4,4,5,5));

        int[] idx = new int[3];
        int[] score = new int[3];
        int maxScore = 0;

        for(int answer : answers){
            for(int k=0; k<3; k++){
                // 정답인지 체크
                if(pattern.get(k).get(idx[k]) == answer)
                    score[k]++;

                // 다음 패턴으로 idx 넘기기 (끝이라면 처음으로 이동)
                if(++idx[k] == pattern.get(k).size())
                    idx[k] = 0;

                // 점수 최대값 갱신
                maxScore = Math.max(maxScore, score[k]);
            }
        }

        // 점수 최대값에 해당하는 사람 저장
        List<Integer> maxPerson = new ArrayList<>();
        for(int k=0; k<3; k++){
            if(score[k] == maxScore){
                maxPerson.add(k+1);
            }
        }

        // 배열로 변환
        int[] answer = new int[maxPerson.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = maxPerson.get(i);
        }

        return answer;
    }
}


