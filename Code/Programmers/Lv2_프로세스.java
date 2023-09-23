package Programmers;

import java.util.*;

/**
 * @title Lv2 프로세스
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42587
 * @date 2023.09.23
 * @notes
 * */
class Lv2_프로세스 {
    public static void main(String[] args) {
    }

    public static int solution(int[] priorities, int location) {
        priorities[location] += 100;

        ArrayList<Integer> orderedP = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int p : priorities) {
            queue.offer(p);
            if(p>100) p-=100;
            orderedP.add(p);
        }
        Collections.sort(orderedP, Collections.reverseOrder());

        int answer = 0;

        while(!queue.isEmpty()){
            int value = queue.poll();
            boolean isTarget = false;
            if(value>100){
                value-=100;
                isTarget = true;
            }
            if(value==orderedP.get(0)){
                answer++;
                orderedP.remove(0);
                if(isTarget) break;
            }
            else{
                if(isTarget) value+=100;
                queue.offer(value);
            }

        }

        return answer;
    }
}


