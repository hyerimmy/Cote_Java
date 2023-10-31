package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.31.
 * @notes
 * - 현대 기출<br>
 * - 투포인터 알고리즘을 생각해내야할텐데..후~<br>
 */

public class s3_3274_두수의합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        ArrayList<Integer> A = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(A);

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());

        int answer = 0;
        int left = 0;
        int right = A.size() - 1;
        while (left < right) {
            if (A.get(left) + A.get(right) == X) {
                answer++;
                left++;
                right--;
            } else if (A.get(left) + A.get(right) > X) {
                right--;
            } else {
                left++;
            }
        }
        System.out.println(answer);

    }
}