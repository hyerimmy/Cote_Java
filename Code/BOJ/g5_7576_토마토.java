package BOJ;

import java.io.IOException;
import java.util.*;

/**
 * @link https://www.acmicpc.net/problem
 * @date 2023.10.25
 * @notes
 * - 골드 따자<br>
 * - 큐 깊은복사!!! -> newQ = new LinkedList<>(Q);<br>
 * - 지도 만들때 M[2][3] -> 가로3 세로2!! 헷갈려죽겠네;<br>

 */

public class g5_7576_토마토 {
    static int N;
    static int M;
    static int[][] B;
    static int targetCnt = 0;
    static int[] DX = {0,0,1,-1};
    static int[] DY = {1,-1,0,0};
    static int days = -1;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        B = new int[M][N];

        Queue<int[]> Q = new LinkedList<>();

        for(int i=0; i<M; i++){
            for(int k=0; k<N; k++){
                B[i][k] = sc.nextInt();
                if(B[i][k]==0) targetCnt++;
                if(B[i][k]==1) Q.add(new int[]{i,k});
            }
        }
        if(targetCnt==0) days=0;
        else BFS(Q);

        System.out.println(days);
    }

    public static void BFS(Queue<int[]> Q){
        Queue<int[]> newQ = new LinkedList<>();
        while(targetCnt>0){
            if(Q.isEmpty()){
                if(newQ.isEmpty()) break;
                Q = new LinkedList<>(newQ);
                newQ.clear();
            }

            int[] P = Q.poll();
            for(int d=0; d<4; d++){
                int newX = P[0]+DX[d];
                int newY = P[1]+DY[d];

                if(newX>=0 && newX<M && newY>=0 && newY<N && B[newX][newY]==0){
                    newQ.add(new int[]{newX, newY});
                    B[newX][newY] = B[P[0]][P[1]]+1;
                    targetCnt--;
                    if(targetCnt==0) days = B[newX][newY]-1;
                }
            }
        }
    }
}

