package BOJ;


import java.io.IOException;
import java.util.Scanner;

/**
 * @title s1427_소트인사이드
 * @link https://www.acmicpc.net/problem/1427
 * @date 2023.08.14
 * @notes
- sort 정렬 활용<br>
 */

public class s5_1427_소트인사이드 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        int[] A = new int[N.length()];
        for (int i=0;i<N.length();i++){
            A[i] = Integer.parseInt(N.substring(i,i+1));
        }

        for (int k=0;k<N.length();k++){
            int maxIndex = k;
            for (int t=k;t<N.length();t++){
                if (A[t] > A[maxIndex]){
                    maxIndex = t;
                }
            }
            int maxN = A[maxIndex];
            A[maxIndex] = A[k];
            A[k] = maxN;
        }

        for (int number : A){
            System.out.print(number);
        }
    }
}

