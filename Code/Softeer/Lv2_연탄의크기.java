package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://softeer.ai/practice/7628
public class Lv2_연탄의크기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int maxCount = 0; // 최대 집 수 저장 변수
        int[] homeA = new int[N]; // 각 집 별 난로 반지름 길이 저장 배열

        // 집의 난로 반지름 길이 입력받기
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            homeA[n] = Integer.parseInt(st.nextToken());
        }

        // 난로 반지름 별 가능한 개수 카운팅하기
        for (int r = 2; r <= 100; r++) {
            int count = 0;
            for (int home : homeA) {
                if (home % r == 0)
                    count++;
            }
            maxCount = Math.max(maxCount, count);
        }

        // 결과 출력
        System.out.println(maxCount);
    }
}
