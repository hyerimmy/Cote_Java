package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.24
 * @notes - 에센셜3+<br>
 */

public class s2_1927_최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 연산수

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            int inputN = Integer.parseInt(br.readLine());
            if(inputN == 0){
                int answer = 0;
                if(!PQ.isEmpty())
                    answer = PQ.poll();
                sb.append(answer).append("\n");
            } else{
                PQ.add(inputN);
            }
        }
        System.out.println(sb);
    }
}

