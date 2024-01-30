package Softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Lv3_스마트물류 {
    public static char[] dataA;
    public static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dataA = br.readLine().toCharArray();
        selected = new boolean[N];

        int answer = 0;

        // 그리디 알고리즘 진행
        for (int i = 0; i < N; i++) {
            // 부품이라면 건너뜀
            if (dataA[i] == 'H')
                continue;

            // 선택 유무
            boolean selectComplete = false;

            // 왼쪽 부품 선택
            for (int gap = K; gap > 0; gap--) {
                selectComplete = selectItem(i - gap);
                if (selectComplete) break;
            }

            // 오른쪽 부품 선택
            if (!selectComplete) {
                for (int gap = 1; gap <= K; gap++) {
                    selectComplete = selectItem(i + gap);
                    if (selectComplete) break;
                }
            }

            if (selectComplete) answer++;
        }

        // 결과 출력
        System.out.println(answer);
    }

    private static boolean selectItem(int position) {
        if (position >= 0 && position < dataA.length && dataA[position] == 'H' && !selected[position]) {
            selected[position] = true;
            return true;
        }
        return false;
    }
}
