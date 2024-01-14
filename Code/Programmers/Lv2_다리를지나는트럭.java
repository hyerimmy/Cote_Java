package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @title Lv2 다리를 지나는 트럭
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42583
 * @date 2024.01.14
 * @notes
 * - 스택큐 프로그래머스 고득점 kit<br>
 * */

class Lv2_다리를지나는트럭 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7,4,5,6}));
    }

    public static Queue<Integer> bridgeQ = new LinkedList<>(); // 다리 상태 저장 큐 (0 : 빈 부분)
    public static int weightSum = 0; // 다리 위 트럭 무게 합
    public static int time = 0; // 소요 시간

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 다리 초기화
        for(int i=0; i<bridge_length; i++){
            bridgeQ.add(0);
        }

        // 트럭 이동
        for(int w : truck_weights){
            while(weightSum - bridgeQ.peek() + w > weight){
                addTruck(0);
            }
            addTruck(w);
        }

        // 결과 반환
        return time + bridge_length;
    }

    private static void addTruck(int truckWeight){
        weightSum -= bridgeQ.poll();
        bridgeQ.add(truckWeight);
        weightSum += truckWeight;
        time++;
        // System.out.println(bridgeQ);
    }
}
