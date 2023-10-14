package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title b1345 시험감독
 * @link https://www.acmicpc.net/problem/1345
 * @date 2023.10.14
 * @notes
 * - SSAFY 기출<br>
 */

public class b13458_시험감독 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int studentN : A) {
            result+=1;
            if(studentN > B){
                result+=(studentN-B)/C;
                if ((studentN-B)%C!=0) result+=1;
            }
        }
        System.out.println(result);

    }
}