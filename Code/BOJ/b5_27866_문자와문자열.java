package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes
 */

public class b5_27866_문자와문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        int i = Integer.parseInt(br.readLine());
        System.out.println(S.charAt(i-1));
    }
}