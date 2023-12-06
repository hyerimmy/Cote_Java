package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @title s11724 연결요소의 개수
 * @link https://www.acmicpc.net/problem/11724
 * @date 2023.09.03
 * @notes
- 제한시간 3초, N 최대 1000 -> N^2으로 해도 (100만) 괜찮음<br>
- DFS 활용 문제, 인접 리스트 사용 <br>
- DFS 총 수행 회수 = 연결 요소 개수(답) <br>
 */

public class s2_11724_연결요소의개수__DFS {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader((System.in))));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1]; //0번 index 사용하지 않기 위함
        A = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A[start].add(end);
            A[end].add(start);
        }
        int count = 0;
        for(int i=1; i<n+1; i++){
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.print(count);
    }

    private static void DFS(int v) {
        if(visited[v]){
            return;
        }
        visited[v] = true;
        for(int i : A[v]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }
}

