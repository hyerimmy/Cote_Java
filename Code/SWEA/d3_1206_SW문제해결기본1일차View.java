package SWEA;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.22
 * @notes
 */

public class d3_1206_SW문제해결기본1일차View {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = sc.nextInt();

            ArrayList<Integer> A = new ArrayList<>();
            for(int i=0; i<N; i++){
                A.add(sc.nextInt());
            }

            int answer = 0;
            for(int i=0; i<N; i++){
                int max = 0;
                if(i-2>0 && A.get(i-2)>max) max=A.get(i-2);
                if(i-1>0 && A.get(i-1)>max) max=A.get(i-1);
                if(i+1<N && A.get(i+1)>max) max=A.get(i+1);
                if(i+2<N && A.get(i+2)>max) max=A.get(i+2);
                if(max<A.get(i)) answer += A.get(i)-max;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}