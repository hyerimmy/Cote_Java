
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06
 * @notes
 * - 에센셜2<br>
 * - 소수 판별 알고리즘 외우기!! ↓ ↓ ↓ <br>
 * - 에라토스테네스의 체 : k=2 부터 √N 이하까지 반복하여 자연수들 중 k를 제외한 k의 배수들을 제외시킨다.<br>
 */

public class s3_1929_소수구하기 {

    static int N;
    static boolean[] isPrimeA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        isPrimeA = new boolean[N+1];
        Arrays.fill(isPrimeA, true);
        isPrimeA[0] = false;
        isPrimeA[1] = false;

        StringBuilder sb = new StringBuilder();
        for (int num = 2; num <= Math.sqrt(N); num++) {
            setPrime(num);
        }

        for (int num = M; num <= N; num++) {
            if (isPrimeA[num])
                sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    public static void setPrime(int num) {
        int target = num;
        while(target + num <= N){
            target += num;
            isPrimeA[target] = false;
        }
    }
}

