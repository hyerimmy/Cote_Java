package Programmers;

import java.util.Stack;

/**
 * @title Lv2 괄호회전하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * @date 2023.09.22
 * @notes
 * - 올바른괄호 와 비슷한 문제<br>
 * */

class Lv2_괄호회전하기 {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        for(int i=0; i<s.length();i++){
            String newS = s.substring(i,s.length()) + s.substring(0,i);
            if(isCorrect(newS)) answer += 1;
        }
        return answer;
    }

    public static boolean isCorrect(String s){
        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for(int i=0; i<s.length();i++){
            char value = s.charAt(i);
            if(value=='[') stack.push(']');
            else if(value=='(') stack.push(')');
            else if(value=='{') stack.push('}');
            else{
                if(!stack.empty() && value==stack.pop()){
                    continue;
                }
                else result = false; break;
            }
        }
        if(stack.empty()) return result;
        return false;
    }

}


