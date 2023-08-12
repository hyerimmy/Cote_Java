package BOJ;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @title 1940 주몽
 * @link https://www.acmicpc.net/problem/1940
 * @date 2023.08.11
 * @notes
- 투포인터 알고리즘 활용<br>
 */

public class s1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];

        for(int i=0; i<N;i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int start_idx = 0;
        int end_idx = N-1;
        long sum = A[start_idx] + A[end_idx];
        int count = 0;

        while (end_idx != start_idx){
            if (sum < M){
                sum = A[++start_idx] + A[end_idx];
            }
            else if (sum > M){
                sum = A[start_idx] + A[--end_idx];
            }
            else{
                count++;
                sum = A[start_idx] + A[--end_idx];
            }
        }
        System.out.println(count);
    }
}

