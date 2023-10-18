package SWEA;

import java.util.Scanner;

/**
 * @title 1926 간단한 369 게임
 * @link https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=2&contestProbId=AV5PTeo6AHUDFAUq&categoryId=AV5PTeo6AHUDFAUq&categoryType=CODE&problemTitle=&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=2&pageSize=10&pageIndex=1
 * @date 2023.10.18
 * @notes
 */

public class d2_1926_간단한369게임 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N;
        N=sc.nextInt();

        for(int i = 1; i <= N; i++)
        {
            String S = Integer.toString(i);
            String clap = "";
            for(int k=0; k<S.length(); k++){
                char c = S.charAt(k);
                if(c=='3' || c=='6' || c=='9') clap+="-";
            }
            if(clap=="") System.out.print(S);
            else System.out.print(clap);
            if(i!=N) System.out.print(" ");
        }

        System.out.println();
    }
}