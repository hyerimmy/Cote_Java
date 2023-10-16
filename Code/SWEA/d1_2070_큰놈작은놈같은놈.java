package SWEA;

import java.util.Scanner;

/**
 * @title 2072 홀수만 더하기
 * @link https://www.acmicpc.net/problem/2072
 * @date 2023.10.15
 * @notes
 */

public class d1_2070_큰놈작은놈같은놈 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#"+test_case+" ");
            int A = sc.nextInt();
            int B = sc.nextInt();
            if(A == B) System.out.println("=");
            else if(A > B) System.out.println(">");
            else System.out.println("<");

        }
    }
}