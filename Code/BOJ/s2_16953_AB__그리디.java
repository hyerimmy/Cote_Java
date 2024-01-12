package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.04.
 * @notes - 에센셜4<br>
 * - 그리디 뿌수자!<br>
 * - *그리디포인트* 뒤에서부터 계산했을 때 (1)짝수, (2) 10x+1꼴인지 확인해서 계산<br>
 */

public class s2_16953_AB__그리디 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        System.out.println(getMinCount(A, B));
    }

    public static int getMinCount(int A, int B) {
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{B, 1});
        while (!Q.isEmpty()) {
            int[] N = Q.poll();
            if (N[0] == A) {
                return N[1];
            } else if(N[0] > A){
                if (N[0] % 2 == 0)
                    Q.add(new int[]{N[0] / 2, N[1] + 1});
                if ((N[0] - 1) % 10 == 0)
                    Q.add(new int[]{(N[0] - 1) / 10, N[1] + 1});
            }
        }
        return -1;
    }
}

