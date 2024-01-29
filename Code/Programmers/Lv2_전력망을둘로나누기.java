package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title Lv2 전력망을 둘로 나누기
 * @link https://school.programmers.co.kr/learn/courses/30/lessons/86971
 * @date 2024.01.29
 * @notes - 프로그래머스 고득점 kit <br>
 */

/*
union find 개념 꼭 기억하기!!!!!!!!
parent 배열에 최소값을 넣는 것으로 짜더라도 예외상황 생김!!
*무조건 부모노드 같은지 판단할 때는 find() 결과값으로만 비교할 것!!!*
*/

class Lv2_전력망을둘로나누기 {
    public static void main(String[] args) {
    }

    public static List<List<Integer>> edgeList = new ArrayList<>(); // 엣지리스트

    // 유니온 파인드 연산
    public static int[] parent;

    public int solution(int n, int[][] wires) {
        // 초기화
        for (int node = 0; node <= n; node++)
            edgeList.add(new ArrayList<>());
        int minDiffer = n - 1;
        parent = new int[n + 1];

        // 엣지리스트 값 입력
        for (int[] W : wires) {
            edgeList.get(W[0]).add(W[1]);
            edgeList.get(W[1]).add(W[0]);
        }

        // 유니온파인드 연산
        for (int breakWireIdx = 0; breakWireIdx < wires.length; breakWireIdx++) {
            // parent 배열 초기화
            for (int node = 1; node <= n; node++)
                parent[node] = node;

            // 집합 합치기
            for (int w = 0; w < wires.length; w++) {
                if (w == breakWireIdx) // 끊은 전선은 연결하지 않음
                    continue;

                union(wires[w][0], wires[w][1]);
            }

            // 한 묶음 송전탑 개수 카운팅 초기화 (1번째 노드와 같은 집합 카운팅)
            int count = 1;
            int target = find(1);
            for (int i = 2; i <= n; i++) {
                if (find(i) == target) count++;
            }

            // 두 전력망의 송전탑 개수 차이 계산해 결과값 갱신
            int differ = Math.abs(n - 2 * count);
            minDiffer = Math.min(minDiffer, differ);

            // System.out.println(Arrays.toString(parent));
            // System.out.println(breakWireIdx+" break -> "+count+", "+(n-count));
        }

        return minDiffer;
    }

    private void union(int nodeIdx1, int nodeIdx2) {
        int pIdx1 = find(nodeIdx1);
        int pIdx2 = find(nodeIdx2);

        // 이미 같은 집합이라면 종료
        if (pIdx1 == pIdx2)
            return;

        // 부모노드 통일 (작은 값을 부모노드인덱스로 채택)
        parent[pIdx1] = pIdx2;
    }

    private int find(int nodeIdx) {
        if (parent[nodeIdx] == nodeIdx)
            return nodeIdx;

        return parent[nodeIdx] = find(parent[nodeIdx]);
    }
}


