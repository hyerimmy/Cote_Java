package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lv3_우물안개구리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 무게 입력받기
        int[] W = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int n = 1; n <= N; n++) {
            W[n] = Integer.parseInt(st.nextToken());
        }

        // 관계 리스트 초기화
        List<List<Integer>> edges = new ArrayList<>();
        for (int n = 0; n <= N; n++) {
            edges.add(new ArrayList<Integer>());
        }

        // 관계 입력받기
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int person1 = Integer.parseInt(st.nextToken());
            int person2 = Integer.parseInt(st.nextToken());
            edges.get(person1).add(person2);
            edges.get(person2).add(person1);
        }

        // 최고인 회원 개수 세기
        int answer = 0;
        for (int person = 1; person <= N; person++) {
            boolean isBest = true;
            for (int friend : edges.get(person)) {
                if (W[friend] >= W[person]) {
                    isBest = false;
                    break;
                }
            }

            // System.out.println(person+" : "+isBest);

            if (isBest) answer++;
        }

        // 결과 출력하기
        System.out.println(answer);
    }
}
