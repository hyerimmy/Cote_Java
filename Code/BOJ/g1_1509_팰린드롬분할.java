package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.03.30.
 * @notes - DP, 투포인터 활용 -> 예외 발생 <br/>
 * - DP, DP 활용 <br/>
 * - 아싸 한 번에 풀었지롱~~~ 신난다구리~~ <br/>
 */

public class g1_1509_팰린드롬분할 {
    public static char[] inputs; // 입력된 문자열 배열
    public static boolean[][] isPallindromA;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        inputs = br.readLine().toCharArray();

        // 팰린드롬 검증 결과값 2차원 배열에 저장
        isPallindromA = new boolean[inputs.length][inputs.length];
        setIsPallindromArray();

        // 투포인터로 분할 개수 최소값 탐색
        int result = getMinCount();

        // 결과 출력
        System.out.println(result);

        br.close();
    }

    private static void setIsPallindromArray() {
        for (int eIdx = 0; eIdx < inputs.length; eIdx++) {
            for (int sIdx = 0; sIdx <= eIdx; sIdx++) {
                boolean isPallindrom = true;

                // 첫 값과 끝 값이 같지 않다면 팰린드롬이 아니다.
                if (inputs[sIdx] != inputs[eIdx]) {
                    isPallindrom = false;
                }

                // 중간 값으로 들어간 문자열이 팰린드롬이 아니라면 팰린드롬이 아니다.
                if (eIdx - sIdx >= 2 && !isPallindromA[sIdx + 1][eIdx - 1]) {
                    isPallindrom = false;
                }

                isPallindromA[sIdx][eIdx] = isPallindrom;
            }
        }
    }

    private static int getMinCount() {
        int[] minCountA = new int[inputs.length];
        Arrays.fill(minCountA, Integer.MAX_VALUE); // 가장 큰 수로 초기화

        minCountA[0] = 1;
        for (int target = 1; target < inputs.length; target++) {
            for (int start = 0; start <= target; start++) {
                // 팰린드롬 불가능한 시작점이라면 건너뜀
                if (!isPallindromA[start][target])
                    continue;

                // 최소 분할개수 갱신
                int prevMinCount = start - 1 >= 0 ? minCountA[start - 1] : 0;
                minCountA[target] = Math.min(minCountA[target], prevMinCount + 1);
            }
        }

//        System.out.println(Arrays.toString(minCountA));
        return minCountA[inputs.length - 1];
    }
}

// ABACABA
