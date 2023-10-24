package SWEA;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.24
 * @notes
 */

public class d3_2805_농작물수확하기 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;
            int N = sc.nextInt();
            int range = 1;
            int diff = 2;

            for(int i=0; i<N; i++){
                int startIdx = (N-range)/2;
                int endIdx = N-startIdx-1;

                String input = sc.next();
                for(int k=startIdx; k<=endIdx; k++){
                    answer += input.charAt(k)-'0';
                }
                if(range==N) diff = -2;
                range += diff;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}