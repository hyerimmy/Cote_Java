package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @link https://www.acmicpc.net/problem/1932
 * @date 2023.12.11.
 * @notes - 스택 활용, 후위표기 스택으로 표현한는 방법 익혀보자  <br>
 * - 블로그 보고 풀었다. 어렵다. 스택 활용 기법 좀 잘 익혀보자고~~ <br>
 */

// A+B*C-D/E
public class g2_1918_후위표기식 {
    public static StringBuilder totalSb = new StringBuilder(); // 결과값 스트링빌더
    public static Stack<Character> operatorStack = new Stack<>(); // 기호 스택

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] expression = br.readLine().toCharArray();

        for (char e : expression) {
            // 대문자 문자열이라면
            if ((int) e >= 65 && (int) e <= 90) {
                totalSb.append(e);
                continue;
            }

            // 기호라면
            updateOperator(e);
        }
        while(!operatorStack.isEmpty()){
            totalSb.append(operatorStack.pop());
        }
        System.out.println(totalSb);
    }

    private static void updateOperator(char c){
        // 기호 스택 비어있다거나 열린 괄호라면 그냥 넣고 종료
        if(operatorStack.isEmpty() || c=='('){
            operatorStack.add(c);
            return;
        }

        // 닫힌 괄호라면 열린괄호까지 빼고 종료
        if(c == ')'){
            while(!operatorStack.isEmpty() && operatorStack.peek() != '('){
                totalSb.append(operatorStack.pop());
            }
            operatorStack.pop();
            return;
        }

        // 일반 기호라면 우선순위 체크해서 넣고 빼기
        while(!operatorStack.isEmpty() && getPriority(operatorStack.peek()) >= getPriority(c)){
            totalSb.append(operatorStack.pop());
        }
        operatorStack.add(c); // 현재 기호 스택에 넣기
    }

    private static int getPriority(char c) {
        if (c == '*' || c == '/')
            return 2;
        if (c == '+' || c == '-')
            return 1;
        return 0;
    }
}