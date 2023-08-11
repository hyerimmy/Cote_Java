package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * @title 11659 구간합구하기4
 * @link https://www.acmicpc.net/problem/11659
 * @date 2023.08.11
 * @notes
- 많은 입력값을 받을 때에는 BufferReader 사용<br>
- 숫자가 쭉 나열된 것을 받을 때는 문자열로 받아 숫자로 변환, StringTokenizer 사용<br>
- 숫자 덧셈, 곱셈 연산을 할 때에는 숫자가 많이 커질 수 있으니 습관적으로 long 타입 선언<br>
 */

public class s11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] S = new long[N+1];
        S[0] = 0;

        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<N+1;i++){
            int number = Integer.parseInt(st.nextToken());
            S[i] = S[i-1] + number;
        }

        for(int k=0;k<M;k++){
            st = new StringTokenizer(bf.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j]-S[i-1]);
        }
    }
}

