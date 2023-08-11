package BOJ;

import java.util.Scanner;

/**
 * @title 1546 평균
 * @link https://www.acmicpc.net/problem/1546
 * @date 2023.08.11
 * @notes
 * - 수학식을 미리 손으로 적어 최대한 간단한 식을 도출 (코딩하기 쉬워짐) <br>
 * - 문법 익히기 위해 배열로 저장해서 풀이함. 효율을 높이기<br>
 */

public class b1546_평균 {
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