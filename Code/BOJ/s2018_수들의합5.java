package BOJ;


import java.util.Scanner;

/**
 * @title 2018 수들의합5
 * @link https://www.acmicpc.net/problem/2018
 * @date 2023.08.11
 * @notes
- 투포인터 알고리즘 활용<br>
 */

public class s2018_수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start_idx = 1;
        int end_idx = 1;
        long sum = 1;
        int count = 0;

        while (end_idx != N){
            if (sum < N){
                sum = sum + ++end_idx;
            }
            else if (sum > N){
                sum = sum - start_idx++;
            }
            else{
                count++;
                sum = sum + ++end_idx;
            }
        }
        System.out.println(count+1);
    }
}

