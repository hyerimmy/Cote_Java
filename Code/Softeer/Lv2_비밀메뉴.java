package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Lv2_비밀메뉴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()); // 비밀메뉴 버튼 조작 수
        int N = Integer.parseInt(st.nextToken()); // 사용자 버튼 조작 수
        int K = Integer.parseInt(st.nextToken()); // 버튼 수

        int[] secretButtons = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            secretButtons[i] = Integer.parseInt(st.nextToken());
        }

        boolean hasSecret = false;
        int[] userButtons = new int[N];
        st = new StringTokenizer(br.readLine());


        for(int i=0; i<N; i++){
            userButtons[i] = Integer.parseInt(st.nextToken());
            if(i+1 >= M){ // 조회된 사용자버튼 수가 비밀버튼수보다 크거나 같을 때
                hasSecret = true;
                for(int t=1; t<=M; t++){
                    if(userButtons[i+1-t]!=secretButtons[M-t]){
                        hasSecret = false;
                        break;
                    }
                }
                if(hasSecret) break;
            }
        }
        System.out.println(hasSecret?"secret":"normal");
    }
}
