package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.06.
 * @notes - 에센셜2+ <br>
 * - Comparator 문법 익히기, 무조건 return 0 추가하는게 에러 방지하기 좋음! <br>
 */

public class s5_11650_좌표정렬하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<int[]> pList = new ArrayList<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            pList.add(new int[]{
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            });
        }

        Collections.sort(pList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                if(o1[1] != o2[1])
                    return o1[1] - o2[1];
                return 0;
            }
        });

        for(int[] P : pList){
            System.out.println(P[0]+" "+P[1]);
        }


    }
}