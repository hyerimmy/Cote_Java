package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title s2178 미로탐색
 * @link https://www.acmicpc.net/problem/2178
 * @date 2023.09.04.
 * @notes
- BFS 활용<br>
 */

public class s1_2178_미로탐색__BFS {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int[][] A;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int n=0; n<N; n++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();

            for (int m=0; m<M; m++) {
                A[n][m] = Integer.parseInt(line.substring(m,m+1));
            }
        }

        BFS();
        System.out.println(A[N-1][M-1]);

    }

    private static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0});
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k=0; k<4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M){ // 배열 넘어가면 안 됨
                    if(A[x][y]!=0&&!visited[x][y]){ //0이어서 갈 수 없거나 방문한 노드가 아닌 경우
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //depth 넣어줌
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }
    }
}

