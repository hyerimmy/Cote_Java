package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @title 10820 문자열분석
 * @link https://www.acmicpc.net/problem/10820
 * @date 2023.10.12
 * @notes
 * - SSAFY 기출문제 <br>
 */

public class b10820_문자열분석 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String S = null;


        while ((S = bf.readLine()) != null) {
            int lowerCnt = 0;
            int UpperCnt = 0;
            int numberCnt = 0;
            int blankCnt = 0;

            for(int i=0; i<S.length(); i++){
                char C = S.charAt(i);
                if(C==' ') blankCnt++;
                else if(65<=(int)C && (int)C<=90) UpperCnt++;
                else if(97<=(int)C && (int)C<=122) lowerCnt++;
                else if(48<=(int)C && (int)C<=57) numberCnt++;
            }

            System.out.println(lowerCnt+" "+UpperCnt+" "+numberCnt+" "+blankCnt);
        }
    }
}