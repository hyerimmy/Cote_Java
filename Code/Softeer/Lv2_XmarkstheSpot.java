package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://softeer.ai/practice/7703
public class Lv2_XmarkstheSpot {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder(); // 결과

        // 글자 구해서 합치기
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            String T = st.nextToken().toUpperCase();

            // x or X 인덱스 구하기
            int idx = getIndex(S);

            // 문자열 합치기
            sb.append(T.charAt(idx));
        }

        // 출력하기
        System.out.println(sb);
    }

    private static int getIndex(String S) {
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'x' || S.charAt(i) == 'X')
                return i;
        }
        return -1;
    }
}
