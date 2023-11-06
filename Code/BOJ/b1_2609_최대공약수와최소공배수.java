package BOJ;

import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes
 * - 에센셜2+ <br>
 */

public class b1_2609_최대공약수와최소공배수 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int smallN = sc.nextInt();
        int bigN = sc.nextInt();

        if(smallN > bigN){
            int temp = smallN;
            smallN = bigN;
            bigN = temp;
        }

        int maxGong = 0; // 최대 공약수
        for(int i=1; i<=bigN; i++){
            if(smallN % i == 0 && bigN % i == 0)
                maxGong = i;
        }

        int minGong = 0; // 최소 공배수
        for(int i=1; i<=smallN; i++){
            if(bigN * i % smallN == 0) {
                minGong = bigN * i;
                break;
            }
        }
        System.out.println(maxGong);
        System.out.println(minGong);

    }
}