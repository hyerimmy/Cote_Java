package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.26
 * @notes
 * - 골드 따자<br>
 * - 그래프 첫 도전
 * - 배열 깊은복사!!! int[] newA = Arrays.copyOf(oldA, oldA.length)
 * - 깊은복사가 문제가 아니었다.. BFS로 하면 메모리초과!! 큐에 너무 많은 데이터가 들어감. DFS에 적합한 문제
 * - 기억하자, DFS는 전역변수랑 한 쌍!!!!! 재귀함수 하다가 조건에 맞으면 전역변수를 수정해서 결과 처리!

 */

public class g5_13023_ABCDE {
    public static int N;
    public static int M;
    public static ArrayList<ArrayList<Integer>> graph;
    public static boolean existFriend = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i=0; i<N; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            graph.get(A).add(B);
            graph.get(B).add(A);
        }

        for(int start=0; start<N; start++){
            for(int end : graph.get(start)){
                boolean[] visitedNode = new boolean[N];
                visitedNode[start]=true;
                visitedNode[end]=true;
                DFS(new Friend(visitedNode, 2, end));
                if(existFriend) break;
            }
            if(existFriend) break;
        }

        System.out.println(existFriend?1:0);
    }

    public static void DFS(Friend F){
        if(F.visitedCnt>=5) existFriend = true;
        else{
            for(int end : graph.get(F.currentNode)){
                boolean[] newVisitedNode = Arrays.copyOf(F.visitedNode, F.visitedNode.length);
                newVisitedNode[end] = true;
                if(!F.visitedNode[end]){
                    DFS(new Friend(newVisitedNode, F.visitedCnt+1, end));
                }
            }
        }
    }
}

class Friend{
    boolean[] visitedNode;
    int visitedCnt;
    int currentNode;
    public Friend(boolean[] visitedNode, int visitedCnt, int currentNode){
        this.visitedNode = visitedNode;
        this.visitedCnt = visitedCnt;
        this.currentNode = currentNode;
    }
}

