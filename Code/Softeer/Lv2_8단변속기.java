package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Lv2_8단변속기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean goUp = true;
        boolean goDown = true;
        for(int i=0; i<8; i++){
            int inputN = Integer.parseInt(st.nextToken());
            if(goUp){
                if(inputN != i+1) goUp = false;
            }
            if(goDown){
                if(inputN != 9-i-1) goDown = false;
            }
            if(!goUp && !goDown) break;
        }
        if(goUp) System.out.println("ascending");
        if(goDown) System.out.println("descending");
        if(!goUp && !goDown) System.out.println("mixed");
    }
}
