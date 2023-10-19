package SWEA;

import java.util.Scanner;

/**
 * @title 1989_초심자의회문검사
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PyTLqAf4DFAUq&categoryId=AV5PyTLqAf4DFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * @date 2023.10.19
 * @notes
 */

public class d2_1989_초심자의회문검사 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            String S = sc.next();
            int result=1;
            for(int i=0; i<S.length()/2; i++){
                if(S.charAt(i)!=S.charAt(S.length()-i-1)){
                    result=0;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}