package Programmers;

import java.util.*;

/**
 * @title Lv2 기능개발
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * @date 2023.09.23
 * @notes
 * - BFS 활용 <br>
 * */

class Lv2_기능개발 {
    public static void main(String[] args) {
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> Q = new LinkedList<>();
        for(int i=0; i<progresses.length;i++){
            Q.offer((int)(Math.ceil((double)(100-progresses[i])/speeds[i])));
        }


        int[] temp = { 1123, 1412, 23, 44, 512132 };
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(temp));

        List<Integer> answer = new ArrayList<>();
        int days=0;
        while(!Q.isEmpty()){
            int value = Q.poll();
            System.out.println(value+" "+days);
            if(value > days) {
                days=value;
                answer.add(1);
            }
            else answer.set(answer.size()-1,answer.get(answer.size()-1)+1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}


