package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.02
 * @notes - 그리디<br>
 * - 노가다 문제, 그냥 3가지 경우에 대해 모두 구하는 것
 */

public class s3_27922_현대모비스입사프로젝트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 강의 수
        int K = Integer.parseInt(st.nextToken()); // 수강할 강의 수

        // case1Sum : 역량1, 역량2 선택
        // case2Sum : 역량1, 역량3 선택
        // case3Sum : 역량2, 역량3 선택
        List<Integer> case1Sum = new ArrayList<>();
        List<Integer> case2Sum = new ArrayList<>();
        List<Integer> case3Sum = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int skill1 = Integer.parseInt(st.nextToken());
            int skill2 = Integer.parseInt(st.nextToken());
            int skill3 = Integer.parseInt(st.nextToken());

            // 총 3가지 경우에 대한 역량 점수 합 배열에 저장하기
            case1Sum.add(skill1 + skill2);
            case2Sum.add(skill1 + skill3);
            case3Sum.add(skill2 + skill3);
        }

        // 점수 합 큰 순서대로 정렬하기
        Collections.sort(case1Sum, Collections.reverseOrder());
        Collections.sort(case2Sum, Collections.reverseOrder());
        Collections.sort(case3Sum, Collections.reverseOrder());

        // 각 경우 (case 1~3)에 대한 최고값 구하기
        int case1Max = 0;
        int case2Max = 0;
        int case3Max = 0;
        for (int k = 0; k < K; k++) {
            case1Max += case1Sum.get(k);
            case2Max += case2Sum.get(k);
            case3Max += case3Sum.get(k);
        }

        // 결과 출력하기
        int result = Math.max(Math.max(case1Max, case2Max), case3Max);
        System.out.println(result);

    }
}

