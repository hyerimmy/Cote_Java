package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.09.
 * @notes - 에센셜2++ <br>
 */

public class s4_4949_균형잡힌세상 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String sentence = br.readLine();
            if(sentence.equals("."))
                break;

            Stack<Character> S = new Stack<>();
            boolean answer = true;
            for(int i=0; i<sentence.length(); i++){
                switch (sentence.charAt(i)){
                    case '(':
                        S.push('(');
                        break;
                    case '[':
                        S.push('[');
                        break;
                    case ')':
                        if(S.isEmpty() || S.pop() != '(')
                            answer = false;
                        break;
                    case ']':
                        if(S.isEmpty() || S.pop() != '[')
                            answer = false;
                        break;
                }
                if(!answer)
                    break;
            }
            if(!S.isEmpty())
                answer = false;

            System.out.println(answer?"yes":"no");
        }
    }
}