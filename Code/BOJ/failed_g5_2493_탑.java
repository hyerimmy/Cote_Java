package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.25
 * @notes
 * - 골드 따자<br>
 * - 시간초과 문제 제약사항의 범위가 크기 때문에 (500,000) 시간복잡도 고려해야함.
 * - 메모리초과 -> bufferdReader랑 Stringtokenizer!!! 쓰는 습관 만들자.
 * - 큐가 아니라 스택 활용하는 문제!!! 문제 이해 잘 할 수 있도록 머리굴리자.
 */

public class failed_g5_2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] heightA = new int[N];
        int[] answerA = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            heightA[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> S = new Stack<>();
        for(int i=N-1; i>=0; i--){
            while(!S.empty() && heightA[S.peek()]<heightA[i]){
                answerA[S.pop()] = i+1;
            }
            S.push(i);
        }

        for(int i=0; i<N; i++){
            System.out.print(answerA[i]);
            if(i!=N-1) System.out.print(" ");
        }

    }
}

