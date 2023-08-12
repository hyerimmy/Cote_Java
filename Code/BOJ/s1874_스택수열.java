package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

/**
 * @title s1874_스택수열
 * @link https://www.acmicpc.net/problem/1874
 * @date 2023.08.12
 * @notes
- 스택 활용<br>
- 스택의 개념을 정확히 알고 있다면 풀 수 있는 문제<br>
 */

public class s1874_스택수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Stack<Integer> stack = new Stack<Integer>();
        List<String> resultList = new ArrayList<String>();
        int targetN;
        int readyN = 1;
        stack.add(readyN++);
        resultList.add("+");


        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            targetN = Integer.parseInt(st.nextToken());
            if (stack.empty()){
                stack.add(readyN++);
                resultList.add("+");
            }
            if (stack.peek() > targetN){
                break;
            }
            while (stack.peek() < targetN){
                stack.add(readyN++);
                resultList.add("+");
            }
            if (stack.peek() == targetN){
                stack.pop();
                resultList.add("-");
            }
        }

        if (resultList.size() < N*2){
            System.out.println("NO");
        }
        else {
            for (String result : resultList) {
                System.out.println(result);
            }
        }
    }

}

