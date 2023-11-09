
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.09.
 * @notes - 에센셜2++<br>
 */

public class s5_7568_덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람 수

        int[][] size = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            size[i] = new int[]{W, H};
        }

        for (int i = 0; i < N; i++) {
            int answer = 1;
            for (int k = 0; k < N; k++) {
                if(i==k)
                    continue;
                if(size[i][0] < size[k][0] && size[i][1] < size[k][1]){
                    answer++;
                }
            }
            System.out.print(answer+" ");
        }

    }
}

