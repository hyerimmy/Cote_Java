package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @link https://www.acmicpc.net/problem/1543
 * @date 2024.04.14
 * @notes - <br>
 */

public class s5_1543_문서검색 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String target = br.readLine();

        int targetIdx = 0;
        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            // 시작점 가능성이 있다면 탐색 진행
            if (input.charAt(i) == target.charAt(0)) {

                // 범위를 벗어난다면 탐색 불가
                if (i + target.length() - 1 > input.length() - 1)
                    continue;

                boolean canCount = true;

                for (int t = 0; t < target.length(); t++) {
                    if (input.charAt(i + t) != target.charAt(t)) {
                        canCount = false;
                        break;
                    }
                }

                if (canCount) {
                    i += target.length() - 1;
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}

/*
abababc
ababc
 */