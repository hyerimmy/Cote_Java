package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.12.16.
 * @notes - 에센셜4 <br>
 * - 이진트리 뿌숴보자 <br>
 * - 어려웠돠..<br>
 * - 전위탐색 결과로 그래프를 생성하든 말든, 그냥 이진트리 특징(작은값은 왼쪽, 큰값은 오른쪽)에 맞춰서 그래프 생성하도록 코드 작성하면 머리 안복잡하고 오류 안생김! <br>
 */

public class g5_5639_이진검색트리 {
    public static List<Node> graph = new ArrayList<>();
    public static boolean[] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 그래프 입력받기
        while (true) {
            String input = br.readLine();
            if (input == null || input.equals(""))
                break;

            updateGraph(0, Integer.parseInt(input));
        }

        // 후위순회
        visited = new boolean[graph.size()];
        search(0);

        // 결과 출력
        System.out.println(sb);

//        for (Node n : graph) {
//            System.out.printf("[%d] left : %d / right : %d / root : %d %n", n.value, n.left, n.right, n.root);
//        }
    }

    public static void updateGraph(int rootNodeIdx, int value) {
        if(graph.isEmpty()){
            graph.add(new Node(value)); // 그래프에 노드 추가
            return;
        }

        if (graph.get(rootNodeIdx).value > value) {
            if (graph.get(rootNodeIdx).left == -1) {
                graph.add(new Node(value)); // 그래프에 노드 추가
                graph.get(rootNodeIdx).left = graph.size() - 1;
                graph.get(graph.size() - 1).root = rootNodeIdx;
            } else {
                updateGraph(graph.get(rootNodeIdx).left, value);
            }
        } else if (graph.get(rootNodeIdx).value < value) {
            if (graph.get(rootNodeIdx).right == -1) {
                graph.add(new Node(value)); // 그래프에 노드 추가
                graph.get(rootNodeIdx).right = graph.size() - 1;
                graph.get(graph.size() - 1).root = rootNodeIdx;
            } else {
                updateGraph(graph.get(rootNodeIdx).right, value);
            }
        }
    }

    public static void search(int startNode) {
        if (graph.get(startNode).left != -1)
            search(graph.get(startNode).left);

        if (graph.get(startNode).right != -1)
            search(graph.get(startNode).right);

        sb.append(graph.get(startNode).value).append("\n");
    }

    public static class Node {
        public int value;
        public int root = -1;
        public int left = -1;
        public int right = -1;

        public Node(int value) {
            this.value = value;
        }
    }
}