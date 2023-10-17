package SWEA;

import java.util.Scanner;

/**
 * @title 1986 지그재그 숫자
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PxmBqAe8DFAUq&categoryId=AV5PxmBqAe8DFAUq&categoryType=CODE&problemTitle=&orderBy=PASS_RATE&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * @date 2023.10.17
 * @notes
 */

public class d2_1986_지그재그숫자 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int answer = -N/2;
            if(N%2!=0) answer+=N;
            System.out.println("#"+test_case+" "+answer);

        }
    }
}