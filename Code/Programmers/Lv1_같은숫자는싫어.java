package Programmers;

import java.util.*;

/**
 * @title Lv1 포켓몬
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * @date 2023.09.23
 * @notes
 * - stack 활용 <br>
 * */

class Lv1_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = {1,1,3,3,0,1,1};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int n : arr){
            if(stack.empty()) stack.push(n);
            else if(stack.peek()!=n) stack.push(n);
        }

        int[] answer = new int[stack.size()];
        int i = 0;
        for(int n : stack) answer[i++]=n;

        return answer;
    }

}


