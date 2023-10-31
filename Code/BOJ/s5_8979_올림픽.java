package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.31.
 * @notes - 현대 기출<br>
 */

public class s5_8979_올림픽 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //국가수
        int K = Integer.parseInt(st.nextToken()); //타겟국가



        // 입력받기
        int[][] S = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            S[key][0] = Integer.parseInt(st.nextToken());
            S[key][1] = Integer.parseInt(st.nextToken());
            S[key][2] = Integer.parseInt(st.nextToken());
        }

        // 등수 계산하기
        int rank = 0;
        for (int[] target : S) {
            if(isStronger(target, S[K])) rank++;
        }
        System.out.print(rank+1);
    }

    public static boolean isStronger(int[] A, int[] B) {
        if (A[0] > B[0]) {
            return true;
        }
        if (A[0] == B[0] && A[1] > B[1]) {
            return true;
        }
        if (A[0] == B[0] && A[1] == B[1] && A[2] > B[2]) {
            return true;
        }
        return false;
    }
}

