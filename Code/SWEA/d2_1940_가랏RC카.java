package SWEA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @link https://swexpertacademy.com
 * @date 2023.10.19
 * @notes
 */

public class d2_1940_가랏RC카 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int answer = 0;
            int speed = 0;
            for(int i=0; i<N; i++){
                int state = sc.nextInt();
                if(state>0) {
                    int d = sc.nextInt();
                    if(state==1) speed+=d;
                    else if(state==2) speed-=d;
                }
                if(speed<0) speed=0;
                answer += speed;
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}