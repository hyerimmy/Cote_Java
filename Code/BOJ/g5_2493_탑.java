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
 * - 시간초과 -> 문제 유형에 익숙해지자
 */

public class g5_2493_탑 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Stack<Top> S = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int height = Integer.parseInt(st.nextToken());
            while(true){
                if(S.empty()){
                    System.out.print("0 ");
                    break;
                }
                if(S.peek().height < height){
                    S.pop();
                }
                else{
                    System.out.print(S.peek().idx+" ");
                    break;
                }
            }
            S.push(new Top(i+1, height));
        }
    }
}

class Top{
    int idx;
    int height;

    public Top(int idx, int height){
        this.idx=idx;
        this.height=height;
    }
}

