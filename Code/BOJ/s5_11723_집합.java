package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.20.
 * @notes - 에센셜3<br>
 * - 시간초과 : string builder 사용하니 성공.
 */

public class s5_11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashSet<Integer> H = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            if(action.equals("add"))
                H.add(Integer.parseInt(st.nextToken()));
            if(action.equals("remove"))
                H.remove(Integer.parseInt(st.nextToken()));
            if(action.equals("check")){
                if(H.contains(Integer.parseInt(st.nextToken())))
                    sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            if(action.equals("toggle")){
                int number = Integer.parseInt(st.nextToken());
                if(H.contains(number))
                    H.remove(number);
                else H.add(number);
            }
            if(action.equals("all")){
                H.clear();
                for (int i = 1; i <= 20; i++) {
                    H.add(i);
                }
            }
            if(action.equals("empty"))
                H.clear();
        }

        System.out.println(sb);
    }
}
