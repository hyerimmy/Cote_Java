package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title Lv2 n^2배열
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/87390
 * @date 2023.09.25
 * @notes
 * - long형으로 입력받는 문제일 때는 int형 변환 잘 하기!!!<br>
 * - 어디서 int로 형변환 하느냐에 따라서 반올림때문에 정확도 실패가 될 수 있음!!<br>
 * */

class failed_Lv2_2xn타일링 {
    public static void main(String[] args) {
    }

    public static int answer = 0;

    public static int solution(int n) {
        getCnt(n);
        return answer%1000000007;
    }

    public static void getCnt(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        while(!queue.isEmpty()){
            int size = queue.poll();
            if(size<2) answer++;
            else {
                queue.offer(size-1);
                queue.offer(size-2);
            }
        }
    }


}


