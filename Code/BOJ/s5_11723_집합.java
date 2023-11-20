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
 */

public class s5_11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        HashSet<Integer> H = new HashSet<>();
        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String action = st.nextToken();
            if(action.equals("add"))
                H.add(Integer.parseInt(st.nextToken()));
            if(action.equals("remove"))
                H.remove(Integer.parseInt(st.nextToken()));
            if(action.equals("check")){
                if(H.contains(Integer.parseInt(st.nextToken())))
                    System.out.println(1);
                else System.out.println(0);
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
    }
}

