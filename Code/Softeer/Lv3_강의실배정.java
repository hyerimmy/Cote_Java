package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Lv3_강의실배정 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 강의 수

        ArrayList<int[]> classL = new ArrayList<>();
        for(int n=0; n<N; n++){
            // 강의 시간 리스트에 저장
            st = new StringTokenizer(br.readLine());
            classL.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        Collections.sort(classL, (o1, o2) -> o1[1]-o2[1]);

        long endTime = 0;
        long count = 0;
        for(int[] classTime : classL){
            if(endTime <= classTime[0]){
                endTime = classTime[1];
                count++;
            }
        }
        System.out.println(count);
    }
}
