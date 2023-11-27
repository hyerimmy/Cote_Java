package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.11.27
 * @notes - 에센셜3++<br>
 * - 시간초과 -> visited 배열 추가 -> 메모리초과..<br>
 * - 시간초과 해결 방법 ** -> 그냥 수가 32 이상일 때 0 반환, min 값 0일때 종료! <br>
 * - 중간중간 break 조건만 추가해도 시간단축을 할 수 있다는 점 습관만들기
 */
public class s1_20529_가장가까운세사람의심리적거리 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            String[] mbtiA = new String[N];

            // MBTI 입력받기
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                mbtiA[n] = st.nextToken();
            }

            // 3개씩 심리적 거리 계산값 중 최소값 구하기
            sb.append(getMinNumber(mbtiA)).append("\n");

        }

        System.out.println(sb);
    }

    public static int calculateNumber(String mbti1, String mbti2, String mbti3) {
        int result = 0;
        for (int k = 0; k < 4; k++) {
            if (mbti1.charAt(k) != mbti2.charAt(k)) result++;
            if (mbti2.charAt(k) != mbti3.charAt(k)) result++;
            if (mbti3.charAt(k) != mbti1.charAt(k)) result++;
        }
        return result;
    }

    public static int getMinNumber(String[] mbtiA) {
        if(mbtiA.length > 32)
            return 0;

        int minNumber = 12;
        for (int a = 0; a < mbtiA.length; a++) {
            for (int b = a + 1; b < mbtiA.length; b++) {
                for (int c = b + 1; c < mbtiA.length; c++) {
                    minNumber = Math.min(minNumber, calculateNumber(mbtiA[a],mbtiA[b],mbtiA[c]));
                    if(minNumber == 0)
                        break;
                }
            }
        }
        return minNumber;
    }
}
