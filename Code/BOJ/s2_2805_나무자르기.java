package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.01.
 * @notes - 이분탐색!!
 * - 왜 틀렸나 했더니..~ long형 정의 안해서!!!
 */

public class s2_2805_나무자르기 {
    public static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        trees = new int[N];
        int minTree = Integer.MAX_VALUE;
        int maxTree = 0;
        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            trees[n] = Integer.parseInt(st.nextToken());
            minTree = Math.min(minTree, trees[n]);
            maxTree = Math.max(maxTree, trees[n]);
        }

        int start = minTree - (int) Math.ceil((double) M / N);
        int end = maxTree;
        long answer = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            long result = getCutResult(middle);

            if (result < M) { // 잘리는 나무가 희망하는 나무보다 적다면
                end = middle - 1;
            } else if (result > M) { // 잘리는 나무가 희망하는 나무보다 많다면
                answer = middle;
                start = middle + 1;
            } else {
                answer = middle;
                break;
            }
        }

        System.out.println(answer);
    }

    public static long getCutResult(int cutLimit) {
        long result = 0;
        for (int tree : trees) {
            if (tree > cutLimit)
                result += tree - cutLimit;
        }
        return result;
    }
}
