package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @title Lv2 올바른 괄호
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/12909
 * @date 2023.09.22
 * @notes
 * - 스택 활용 <br>
 * - substring, equals 함수 활용하면 시간 효율 실패 <br>
 * - charAt, =='' 활용하니 시간 효율 성공!! <br>
 * */

class Lv2_올바른괄호 {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
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


