
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.09.
 * @notes - 에센셜2++<br>
 */

public class s5_1676_팩토리얼0의개수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 시리즈 몇 번째
        int countOf2 = 0;
        int countOf5 = 0;

        for (int i = 1; i <= N; i++) {
            int number = i;
            while(number % 2 == 0){
                countOf2 ++;
                number /= 2;
            }
            while(number % 5 == 0){
                countOf5 ++;
                number /= 5;
            }
        }


        System.out.println(Math.min(countOf2, countOf5));
    }
}

