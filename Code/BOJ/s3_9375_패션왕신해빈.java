package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.28.
 * @notes
 * - 수학식 만들어서 코드화하는 간단한 문제
 */

public class s3_9375_패션왕신해빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            HashMap<String, Integer> typeCount = new HashMap<>();

            for(int n=0; n<N; n++){
                st = new StringTokenizer(br.readLine());
                String clothName = st.nextToken();
                String clothType = st.nextToken();
                typeCount.put(clothType, typeCount.getOrDefault(clothType, 0)+1);
            }

            int answer = 1;
            for(int count : typeCount.values()){
                answer *= (count+1);
            }
            sb.append(--answer).append("\n");
        }

        System.out.print(sb);
    }
}

