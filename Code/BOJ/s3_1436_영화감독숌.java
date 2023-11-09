package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.09.
 * @notes - 에센셜2++ <br>
 */

public class s3_1436_영화감독숌 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        while(N > 0){
//            System.out.println(answer);
            answer++;
            if(isSatisfied(answer))
                N--;
        }
        System.out.println(answer);

    }

    public static boolean isSatisfied(int number){
        String numberS = Integer.toString(number);

        boolean answer = false;
        int countSix = 0;
        for (int i = 0; i < numberS.length(); i++) {
            if(numberS.charAt(i) == '6') countSix++;
            else countSix = 0;

            if(countSix >= 3){
                answer = true;
                break;
            }
        }
        return answer;
    }
}