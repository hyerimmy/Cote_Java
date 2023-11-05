package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.05.
 * @notes
 * - 에센셜2<br>
 * - 메모리초과 -> Collections.sort() 대신 Arrays.sort()<br>
 * - 크기를 알 수 있는 것이기 때문에 배열로 정의하는 것이 공간복잡도를 줄일 수 있다!!!!!!<br>
 */

public class b1_10989_수정렬하기3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //숫자 수

        int[] nArr = new int[N];
        for(int i=0; i<N; i++){
            nArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nArr);

        StringBuilder sb = new StringBuilder();

        for(int sortedN : nArr)
            sb.append(sortedN).append("\n");
        System.out.println(sb);
    }
}

