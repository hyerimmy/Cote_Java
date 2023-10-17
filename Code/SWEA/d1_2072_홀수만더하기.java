package SWEA;

import java.util.Scanner;

/**
 * @title 2072 홀수만 더하기
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QSEhaA5sDFAUq&categoryId=AV5QSEhaA5sDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=1
 * @date 2023.10.17
 * @notes
 */

public class d1_2072_홀수만더하기 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int S = 0;
            for(int i=0; i<10; i++){
                int N = sc.nextInt();
                if(N%2!=0) S+=N;
            }
            System.out.println("#"+test_case+" "+S);

        }
    }
}