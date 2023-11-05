package BOJ;

import java.util.Scanner;

/**
 * @title 11720 숫자의 합
 * @link https://www.acmicpc.net/problem/11720
 * @date 2023.08.11
 * @notes
 * - 숫자 최대 자리수 100 -> int, long 불가<br>
 * - `toCharArray` 함수를 활용해 숫자를 배열로 변환<br>
 */

public class b4_11720_숫자의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String sNum = sc.next();
        char[] cNumList = sNum.toCharArray();
        int sum = 0;
        for (int i=0; i<cNumList.length; i++){
            sum += cNumList[i] - '0';
        }
        System.out.println(sum);
    }
}