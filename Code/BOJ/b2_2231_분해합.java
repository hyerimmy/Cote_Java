
package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.08.
 * @notes - 에센셜2++<br>
 */

public class b2_2231_분해합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String Nstring = br.readLine(); // 생성자를 구할 대상 자연수 - 문자열
        int N = Integer.parseInt(Nstring); // 생성자를 구할 대상 자연수

        int answer = 0;
        int maxRange = Math.max(1, N - Nstring.length());
        int minRange = Math.max(1, N - Nstring.length() * 9);

        for (int number = minRange; number <= maxRange; number++) {
            int sum = number;
            String numberString = Integer.toString(number);
            for(int i=0; i<numberString.length(); i++){
                sum += numberString.charAt(i)-'0';
            }
            if (sum == N) {
                answer = number;
                break;
            }
        }
        System.out.println(answer);
    }
}

