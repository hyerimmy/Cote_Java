package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes
 * - 에센셜1++
 */

public class b5_2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;

        for(int i=0; i<5; i++){
            int inputN = Integer.parseInt(st.nextToken());
            answer += inputN * inputN;
        }

        System.out.println(answer%10);
    }
}