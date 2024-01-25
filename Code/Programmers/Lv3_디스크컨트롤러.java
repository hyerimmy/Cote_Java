package Programmers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @title Lv3 디스크 컨트롤러
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42627
 * @date 2024.01.25
 * @notes
 * - 프로그래머스 고득점 kit<br>
 * */

/*
[히든케이스]
작업 종료 시간에 대기열이 비어 있다면 런타임에러
: 대기열의 작업에 접근 가능하도록 가장 가까운 작업 1개 큐에 추가

[히든케이스]
같은시간에 더 긴 duration의 요청이 먼저 들어왔고 해당 시간에 힙이 비어있었다면
: 배열 정렬 시 소요 시간별로도 추가 정렬
*/

class Lv3_디스크컨트롤러 {
    public static void main(String[] args) {
    }

    public int solution(int[][] jobs) {
        // 작업 시작 순으로 정렬
        Arrays.sort(jobs, (j1, j2) -> {
            if(j1[0] != j2[0])
                return j1[0] - j2[0];
            return j1[1] - j2[1];
        });

        // 대기열 정의
        PriorityQueue<Job> jobQ = new PriorityQueue<>();

        int endT = 0; // 작업 종료 시간
        int totalT = 0; // 각 작업 소요 시간 합
        int jIdx = 0; // 작업 인덱스

        // 작업 처리
        for(int complete = 0; complete < jobs.length; complete++){
            // 작업 종료 시점 이하의 작업들 대기열에 추가
            while(jIdx < jobs.length && jobs[jIdx][0] <= endT){
                jobQ.add(new Job(jobs[jIdx][0], jobs[jIdx][1]));
                jIdx++;
            }

            // 대기열에 작업이 없다면 종료시점 이후 작업 추가
            if(jobQ.isEmpty()){
                jobQ.add(new Job(jobs[jIdx][0], jobs[jIdx][1]));
                endT = jobs[jIdx][0]; // 뛰어넘은 만큼 작업 종료 시간 업데이트
                jIdx++;
            }

            // 우선순위 가장 높은 작업 실행
            Job job = jobQ.poll();
            endT += job.time;
            totalT += endT - job.startT;
        }

        return totalT / jobs.length;
    }

    private class Job implements Comparable<Job>{
        public int startT;
        public int time;

        public Job(int startT, int time){
            this.startT = startT;
            this.time = time;
        }

        @Override
        public int compareTo(Job job){
            return this.time - job.time;
        }
    }
}
