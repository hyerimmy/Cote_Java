package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2024.02.02.
 * @notes
 */

/*
배열로 반복문 처리 -> 시간초과
* */

public class s1_26091_현대모비소프트웨어아카데미 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] members = new int[N];
        boolean[] selected = new boolean[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            members[n] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(members);

        // 투포인터
        int leftIdx = 0;
        int rightIdx = members.length - 1;

        while (leftIdx < rightIdx) {
            if (members[leftIdx] + members[rightIdx] >= M) {
                answer++;
                leftIdx++;
                rightIdx--;
            } else if (members[leftIdx] + members[rightIdx] < M) {
                leftIdx++;
            }
        }

        System.out.println(answer);
    }
}