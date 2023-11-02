package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.02
 * @notes
 * - 현대 기출<br>
 * - 메모리 초과 -> Stack을 비교할 때 Queue에 넣는 것 없앴음. 가능하면 큐 같은 타입 변수 잘 쓰지 말자.<br>
 * - 시간초과.. -> Stack을 출력할 때는 String Builder 쓰자!!!! StringBuilder sb = new StringBuilder();
 */

public class g4_9935_문자열폭발 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String S = st.nextToken();
        st = new StringTokenizer(br.readLine());
        String bomb = st.nextToken();


        Stack<Character> stack = new Stack<>();
        for(int i=0; i<S.length(); i++){
            stack.add(S.charAt(i));
            if(stack.size()>=bomb.length()){
                boolean isBomb = true;
                for(int b=0; b<bomb.length(); b++){
                    if(stack.get(stack.size()-b-1) != bomb.charAt(bomb.length()-b-1)){
                        isBomb = false;
                        break;
                    }
                }
                if(isBomb){
                    for(int k=0; k<bomb.length(); k++){
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()){
            System.out.println("FRULA");
        } else{
            for(char c : stack)
                sb.append(c);
            System.out.println(sb);
        }


    }
}

