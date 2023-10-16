package SWEA;

import java.util.Scanner;

/**
 * @title 2072 홀수만 더하기
 * @link https://www.acmicpc.net/problem/2072
 * @date 2023.10.15
 * @notes
 */

public class d1_2072_홀수만더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] scoreList = new int[N];

        for (int i=0;i<N;i++){
            scoreList[i] = sc.nextInt();
        }

        long maxScore = 0;
        long sumScore = 0;

        for (int score : scoreList) {
            if (score > maxScore){
                maxScore = score;
            }
            sumScore += score;
        }

        System.out.println(100 * sumScore / (maxScore * scoreList.length));
    }
}