package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.09.
 * @notes - 에센셜2++ <br>
 */

public class s4_18110_solvedac {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> levelList = new ArrayList<>(); // 난이도 저장 리스트
        for(int i=0; i<N; i++){
            levelList.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(levelList);

        int exceptCount = (int)Math.round(N * 0.15);
        int sum = 0;
        for(int idx = exceptCount; idx < levelList.size() - exceptCount; idx++){
            sum += levelList.get(idx);
        }

        System.out.println(Math.round(sum / (float)(N-exceptCount*2)));


    }
}