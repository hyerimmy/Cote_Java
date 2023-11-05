package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes
 * - 에센셜2<br>
 * - 시간초과 -> 병합정렬 적용해보자.. -> 시간이 최소로 드는 함수 : Collections.sort()!!<br>
 * - 그렇다면 뭐가 문제인가? -> StringBuilder 사용하는 것!!!!!!!!!!!!!!!!!!!<br>
 * - 그냥 출력하는거보다 StringBuilder 쓰면 훨!씬! 시간 단축!!!!<br>
 */

public class s5_2751_수정렬하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //숫자 수

        ArrayList<Integer> nList = new ArrayList<>();
        for(int i=0; i<N; i++){
            nList.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(nList);

        StringBuilder sb = new StringBuilder();

        for(int sortedN : nList)
            sb.append(sortedN).append("\n");
        System.out.println(sb);
    }
}

