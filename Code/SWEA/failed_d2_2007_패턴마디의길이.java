package SWEA;

import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.19
 * @notes
 * - 문제가 이해가 안감. 어떤 것을 패턴으로 선정하는건지 기준이 정확히 안적혀있음.
 */

public class failed_d2_2007_패턴마디의길이 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int cnt = 0;
            String S = sc.next();

            String pattern = ""+S.charAt(0);
            int i=1;
            while(i<S.length()){
                if( i+pattern.length()<=S.length() && S.substring(i,i+pattern.length()).equals(pattern)){
                    cnt++;
                    i+=pattern.length();
                }
                else{
                    i++;
                    pattern=S.substring(0,i);
                    cnt=0;
                }
            }

            System.out.println("#"+test_case+" "+cnt );
        }
    }
}