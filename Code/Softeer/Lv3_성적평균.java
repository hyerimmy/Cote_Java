package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Lv3_성적평균 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학생 수
        int K = Integer.parseInt(st.nextToken()); // 구간 수

        st = new StringTokenizer(br.readLine());
        int[] S = new int[N]; // 성적 저장 배열
        for(int i=0; i<N; i++){
            S[i] = Integer.parseInt(st.nextToken()); // 성적
        }

        for(int k=0; k<K; k++){
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken()) - 1; // 구간 시작 인덱스
            int endIdx = Integer.parseInt(st.nextToken()) - 1; // 구간 종료 인덱스

            float sum = 0;
            for(int idx=startIdx; idx<=endIdx; idx++){
                sum += S[idx];
            }
            System.out.printf("%.2f\n",sum/(endIdx-startIdx+1));
        }
    }
}
