package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2+ <br>
 * - ㅋㅋㅋ.. 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자... 문제 제대로 읽자.. <br>
 */

public class b1_1259_팰린드롬수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        while (!N.equals("0")) {
            boolean isPallindrom = true;
            if(N.length() > 1){
                for (int i = 0; i <= N.length() / 2 - 1; i++) {
                    if (N.charAt(i) != N.charAt(N.length() - i - 1)) {
                        isPallindrom = false;
                        break;
                    }
                }
            }
            if(isPallindrom)
                System.out.println("yes");
            else
                System.out.println("no");

            N = br.readLine();
        }
    }
}