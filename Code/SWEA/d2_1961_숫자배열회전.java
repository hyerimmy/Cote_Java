package SWEA;

import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.19
 * @notes
 */

public class d2_1961_숫자배열회전 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.println("#"+test_case);
            int N = sc.nextInt();
            int[][] M = new int[N][N];
            for(int i=0; i<N;i++){
                for(int j=0; j<N;j++){
                    M[i][j] = sc.nextInt();
                }
            }
            String[] answer = new String[N];

            // 90
            for(int i=0; i<N;i++){
                answer[i]="";
                for(int j=0; j<N;j++){
                    answer[i] += M[N-j-1][i];
                }
                answer[i] += " ";
                for(int j=0; j<N;j++){
                    answer[i] += M[N-i-1][N-j-1];
                }
                answer[i] += " ";
                for(int j=0; j<N;j++){
                    answer[i] += M[j][N-i-1];
                }
            }

            for(int i=0; i<N; i++){
                System.out.println(answer[i]);
            }
        }
    }
}