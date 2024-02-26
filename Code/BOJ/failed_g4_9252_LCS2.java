package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.26.
 * @notes - 1%에서 틀림 ㅎ
 */

public class failed_g4_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S1 = br.readLine();
        String S2 = br.readLine();

        HashMap<Character, List<Integer>> s2Map = new HashMap<>();
        NList[] dp = new NList[S1.length()]; // 길이 긴 순
//        NList[] dp2 = new NList[S1.length()]; // 인덱스 빠른 순
        int maxDpIdx = 0;

        // S2 알파벳 인덱스 맵에 저장
        for (int i = 0; i < S2.length(); i++) {
            List<Integer> indexList = s2Map.getOrDefault(S2.charAt(i), new ArrayList<>());
            indexList.add(i);
            s2Map.put(S2.charAt(i), indexList);
        }

        // S1 DP 탐색 전 0번째 값 초기화
        dp[0] = new NList(-1, "");
        dp2[0] = new NList(-1, "");
        if (s2Map.containsKey(S1.charAt(0))) {
            int s2Idx = s2Map.get(S1.charAt(0)).get(0);
            dp[0] = new NList(s2Idx, dp[0].result + S1.charAt(0));
        }

        // S1 DP 탐색 진행
        for (int i = 1; i < S1.length(); i++) {
            dp[i] = new NList(-1, "");

            // 겹치는 문자열이라면
            if (s2Map.containsKey(S1.charAt(i))) {
                // dp 이전 것들 중 가능한 가장 큰 값으로 갱신
                for (int prev = 0; prev < i; prev++) {
                    NList prevNList = dp[prev];
                    // 갱신 가치가 있다면 반복문 진행
                    if (prevNList.result.length() + 1 > dp[i].result.length()) {
                        // 갱신
                        for (int s2Idx : s2Map.get(S1.charAt(i))) {
                            if (s2Idx > prevNList.s2Idx) {
                                dp[i] = new NList(s2Idx, prevNList.result + S1.charAt(i));
                                break;
                            }
                        }
                    }
                }
            }

            if (dp[maxDpIdx].result.length() < dp[i].result.length()) {
                maxDpIdx = i;
            }
        }

        // 테스트 출력
        for (int i = 0; i < S1.length(); i++) {
            System.out.println(i + " > " + dp[i].s2Idx + " " + dp[i].result);
        }

        // 결과 출력
        System.out.println(dp[maxDpIdx].result.length());
        if (dp[maxDpIdx].result.length() > 0) {
            System.out.println(dp[maxDpIdx].result);
        }
    }

    private static class NList {
        int s2Idx;
        String result;

        public NList(int s2Idx, String result) {
            this.s2Idx = s2Idx;
            this.result = result;
        }
    }
}

/*
ALALALA
LALALA
*/