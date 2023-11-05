package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title b2750_수정렬하기
 * @link https://www.acmicpc.net/problem/2750
 * @date 2023.08.12
 * @notes - 버블 정렬 개념 연관 문제<br>
 * - N의 범위가 굉장히 작기 때문에 n^2의 복잡도를 가져도 크게 부담되지 않음.<br>
 */

public class b2_2750_수정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(bf.readLine());
        }

        boolean swap;

        for (int i = N - 1; i > 0; i--) {
            swap = false;
            for (int k = 0; k < i; k++) {
                if (A[k] > A[k + 1]) {
                    int temp = A[k];
                    A[k] = A[k + 1];
                    A[k + 1] = temp;
                    swap = true;
                }
            }
            if (!swap){
                break;
            }
        }

        for (int result : A) {
            System.out.println(result);
        }

    }
}