package SWEA;

import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.19
 * @notes
 */

public class d2_1959_두개의숫자열 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int aL = sc.nextInt();
            int bL = sc.nextInt();

            int A[] = new int[aL];
            int B[] = new int[bL];

            for(int i=0; i<aL; i++){
                A[i]=sc.nextInt();
            }
            for(int i=0; i<bL; i++){
                B[i]=sc.nextInt();
            }

            if(aL>bL){
                int[] temp = new int[aL];
                temp = A;
                A = new int[bL];
                A=B;
                B = new int[aL];
                B=temp;

                int t = aL;
                aL=bL;
                bL=t;
            }


            int answer = 0;

            for(int start=0; start<bL-aL+1; start++){
                int result = 0;
                for(int gap=0; gap<aL; gap++){
                    result += A[gap]*B[start+gap];
                }
                if(result>answer) answer = result;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}