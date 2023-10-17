package SWEA;

import java.util.Scanner;

/**
 * @title 2071 평균값 구하기
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=1&contestProbId=AV5QRnJqA5cDFAUq&categoryId=AV5QRnJqA5cDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=1&pageSize=10&pageIndex=1&&&&&&&&&&
 * @date 2023.10.17
 * @notes
 */

public class d1_2071_평균값구하기 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int S = 0;
            for(int i=0; i<10; i++){
                S += sc.nextInt();
            }
            System.out.println("#"+test_case+" "+(int)Math.round((float)S/10));

        }
    }
}