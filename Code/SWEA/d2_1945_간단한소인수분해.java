package SWEA;

import java.util.Scanner;

/**
 * @title 1945 간단한 소인소분해
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5Pl0Q6ANQDFAUq&categoryId=AV5Pl0Q6ANQDFAUq&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * @date 2023.10.17
 * @notes
 */

public class d2_1945_간단한소인수분해 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            System.out.print("#"+test_case);
            int N = sc.nextInt();

            int[] target = {2,3,5,7,11};
            for(int t : target){
                int cnt = 0;
                while(N%t==0){
                    N /= t;
                    cnt++;
                }
                System.out.print(" "+cnt);
            }
            System.out.println();

        }
    }
}