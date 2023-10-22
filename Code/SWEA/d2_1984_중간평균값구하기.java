package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.22
 * @notes
 */

public class d2_1984_중간평균값구하기 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sum = 0;
            int min = 10001;
            int max = -1;
            for(int i=0; i<10; i++){
                int N = sc.nextInt();
                sum += N;
                if(N>max) max = N;
                if(N<min) min = N;
            }

            System.out.println("#"+test_case+" "+Math.round((sum-min-max)/8.0));

        }
    }
}