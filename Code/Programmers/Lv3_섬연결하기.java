package Programmers;

import java.util.Arrays;

/**
 * @title Lv3 섬연결하기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/42861
 * @date 2024.01.29
 * @notes - 프로그래머스 고득점 kit <br>
 */

/*
union find 개념 꼭 기억하기!!!!!!!!
*/

class Lv3_섬연결하기 {
    public static void main(String[] args) {
    }

    public static int costSum; // 비용 합계
    public static int[] parents; // 부모 노드 저장 배열

    public int solution(int n, int[][] costs) {
        // 초기화
        costSum = 0;
        parents = new int[n];
        for (int node = 0; node < n; node++)
            parents[node] = node;

        // 비용 적은 순으로 정렬
        Arrays.sort(costs, (o1, o2) -> {
            return o1[2] - o2[2];
        });

        for (int[] C : costs) {
            // System.out.println(Arrays.toString(parents));
            if (union(C[0], C[1]))
                costSum += C[2];
        }

        return costSum;
    }

    private boolean union(int node1, int node2) {
        int a = find(node1);
        int b = find(node2);

        // 이미 연결된 노드라면 건너뜀
        if (a == b)
            return false;

        parents[a] = b;
        return true;
    }

    private int find(int node) {
        if (node == parents[node])
            return node;

        return parents[node] = find(parents[node]);
    }
}


