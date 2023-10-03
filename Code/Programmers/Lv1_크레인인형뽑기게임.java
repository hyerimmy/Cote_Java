package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @title Lv1 크레인 인형뽑기 게임
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/64061
 * @date 2023.10.03
 * @notes
 * */

class Lv1_크레인인형뽑기게임 {
    public static void main(String[] args) {
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> S = new Stack<>();

        for(int M : moves){
            int target = 0;
            for(int[] B : board){
                if(B[M-1]!=0) {
                    target=B[M-1];
                    B[M-1]=0;
                    break;
                }
            }

            if(target!=0){ // 잡힌 인형이 있다면
                if(!S.empty() && S.peek()==target){ // 터트릴경우
                    S.pop();
                    answer+=2;
                }
                else { // 안 터트릴 경우
                    S.push(target);
                }
            }

        }

        return answer;
    }

}


