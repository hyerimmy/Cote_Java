package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27.
 * @notes
 */

public class s4_17219_비밀번호찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> passwordMap = new HashMap<>();

        for(int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            passwordMap.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for(int m=0; m<M; m++){
            sb.append(passwordMap.get(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }
}

