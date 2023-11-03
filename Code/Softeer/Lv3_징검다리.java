package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_징검다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 돌 수

        long[] heightA = new long[N]; // 돌 높이 저장하는 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            heightA[i] = Integer.parseInt(st.nextToken()); // 돌 높이 저장
        }

        int[] dp = new int[N]; // i번째 돌까지 밟을 때 최대 개수 저장 배열
        for(int i=0; i<N; i++){
            dp[i] = 1;
        }

        int answer = 0;
        for(int i=0; i<N; i++){
            for(int k=0; k<i; k++){
                if(heightA[k] < heightA[i]){
                    dp[i] = Math.max(dp[i],dp[k]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
    }
}
