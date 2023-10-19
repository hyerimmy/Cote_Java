package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.19
 * @notes
 */

public class d2_1966_숫자를정렬하자 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            ArrayList<Integer> A = new ArrayList<>();
            for(int i=0; i<N; i++){
                A.add(sc.nextInt());
            }
            Collections.sort(A);
            System.out.print("#"+test_case);
            for(int i=0; i<N;i++){
                System.out.print(" "+A.get(i));
            }
            System.out.println();
        }
    }
}