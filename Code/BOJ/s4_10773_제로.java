
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes - 에센셜2<br>
 */

public class s4_10773_제로 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 부를 수 개수

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int n = 0; n < N; n++) {
            int inputN = Integer.parseInt(br.readLine());
            answer += inputN;

            if(inputN == 0)
                answer -= stack.pop();
            else
                stack.add(inputN);
        }

        System.out.println(answer);
    }
}

