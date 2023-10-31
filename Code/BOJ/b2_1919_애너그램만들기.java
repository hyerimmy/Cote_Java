package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.31.
 * @notes - 현대 기출<br>
 */

public class b2_1919_애너그램만들기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<Character, Integer> hashMap = new HashMap<>();
        String A = st.nextToken();
        for(int i=0; i<A.length(); i++){
            char a = A.charAt(i);
            hashMap.put(a, hashMap.getOrDefault(a,0)+1);
        }

        st = new StringTokenizer(br.readLine());
        String B = st.nextToken();
        int answer = 0;
        for(int i=0; i<B.length(); i++){
            char b = B.charAt(i);
            if(hashMap.getOrDefault(b,0) > 0){
                hashMap.put(b, hashMap.get(b)-1);
            }
            else{
                answer++;
            }
        }

        for(char key : hashMap.keySet()){
            answer+=hashMap.get(key);
        }

        System.out.println(answer);
    }
}

