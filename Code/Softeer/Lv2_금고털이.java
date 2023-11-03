package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Lv2_금고털이 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken()); // 최대무게
        int N = Integer.parseInt(st.nextToken()); // 귀금속 종류

        ArrayList<int[]> itemL = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            itemL.add(new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }

        Collections.sort(itemL, (o1, o2)->o2[1]-o1[1]);

        int leftW = W; // 배낭의 남은 무게
        int answer = 0; // 배낭에 담긴 보석 가격
        for(int[] item : itemL){
            answer += Math.min(item[0],leftW) * item[1];
            leftW -= Math.min(item[0],leftW);
            if(leftW==0) break;
        }
        System.out.println(answer);


    }
}
