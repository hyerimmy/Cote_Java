package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @title Lv2 짝지어제거하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12973
 * @date 2023.09.24
 * @notes
 * - Stack 활용 <br>
 * */

class Lv2_짝지어제거하기 {
    public static void main(String[] args) {
    }

    public static int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length();i++){
            if(!stack.isEmpty() && stack.peek()==s.charAt(i)) stack.pop();
            else stack.push(s.charAt(i));
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }

}


