package SWEA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.24
 * @notes
 */

public class d3_1208_SW문제해결기본1일차Flatten {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int D = sc.nextInt();
            int[] A = new int[100];

            for(int i=0; i<100; i++){
                A[i] = sc.nextInt();
            }
            Arrays.sort(A);

            //System.out.print(A[0]+" "+A[1]+" "+A[2]+" "+A[97]+" "+A[98]+" "+A[99]+"/");

            int idx;
            int temp;

            for(int k=0; k<D; k++){
                A[0]++;
                idx=0;
                while(A[idx]>A[idx+1]){
                    temp=A[idx];
                    A[idx]=A[idx+1];
                    A[idx+1]=temp;
                    idx++;
                }

                A[99]--;
                idx=99;
                while(A[idx-1]>A[idx]){
                    temp=A[idx];
                    A[idx]=A[idx-1];
                    A[idx-1]=temp;
                    idx--;
                }
                //System.out.print(A[0]+" "+A[1]+" "+A[2]+" "+A[97]+" "+A[98]+" "+A[99]+"/");

            }
            System.out.println("#"+test_case+" "+(A[99]-A[0]));
        }
    }
}